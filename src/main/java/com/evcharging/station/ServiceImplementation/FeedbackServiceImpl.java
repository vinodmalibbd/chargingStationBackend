package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DTO.FeedBackDTO;
import com.evcharging.station.Service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public FeedBackDTO addFeedbackOnStation(int chargingStationId, FeedBackDTO feedBackDTO) {
        return null;
    }

    @Override
    public List<FeedBackDTO> getAllFeedbackOfStation(int chargingStationId) {
        return null;
    }

    @Override
    public List<FeedBackDTO> getAllFeedbackOfUser(int userId) {
        return null;
    }
}
