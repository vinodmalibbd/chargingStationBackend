provider "aws" {
  region = "eu-west-1"
  profile = "ec2_instance_user"
}
resource "aws_vpc" "evchagingstation" {
  cidr_block = "10.0.0.0/16"
}

# Create internet gateway
resource "aws_internet_gateway" "evchagingstation" {
  vpc_id = aws_vpc.evchagingstation.id
}

# Create a public subnet
resource "aws_subnet" "public_subnet" {
  vpc_id            = aws_vpc.evchagingstation.id
  cidr_block        = "10.0.1.0/24"
  availability_zone = "eu-west-1a" # Change the availability zone accordingly
  map_public_ip_on_launch = true
}

# Create security group
resource "aws_security_group" "instance_sg" {
  name        = "instance_sg"
  description = "Allow SSH and HTTP traffic"

  vpc_id = aws_vpc.evchagingstation.id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
data "aws_ami" "ubuntu" {
  most_recent = true

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-jammy-22.04-amd64-server-*"]
  }

  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }

  owners = ["099720109477"] # Canonical
}


# Launch EC2 instance
resource "aws_instance" "evstation_backend" {
  ami           = data.aws_ami.ubuntu.id
  instance_type = "t2.micro"
  subnet_id     = aws_subnet.public_subnet.id
  key_name      = "backend"   # Change to your key p

#  security_groups = [aws_security_group.instance_sg.name]
  vpc_security_group_ids = [aws_security_group.instance_sg.id]  # Use security group ID instead of name

  user_data = <<-EOF
              #!/bin/bash

              sudo apt-get update && sudo apt-get install -y openjdk-21-jdk
              EOF
}

# Output public IP of EC2 instance
output "public_ip" {
  value = aws_instance.evstation_backend.public_ip
}
