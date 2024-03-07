package com.evcharging.station.Service;

import com.evcharging.station.DTO.FeedBackDTO;

import java.util.List;

public interface FeedbackService {
    FeedBackDTO addFeedbackOnStation(int chargingStationId,FeedBackDTO feedBackDTO,int userId);
    List<FeedBackDTO> getAllFeedbackOfStation(int chargingStationId);
    List<FeedBackDTO> getAllFeedbackOfUser(int userId);

}
