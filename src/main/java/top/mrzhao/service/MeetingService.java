package top.mrzhao.service;

import top.mrzhao.entity.Meeting;
import top.mrzhao.util.BaseResult;

/**
 * Created by ZY on 2018/5/27.
 */
public interface MeetingService {
    BaseResult SelectMeetingByStatus(Integer meetingStatus);

    BaseResult SelectMeetingByMeetingId(Integer meetingId);

    boolean InsertMeeting(Meeting meeting);

    boolean CancelMeeting(Integer meetingId);

    BaseResult UpdateMeeting(Meeting meeting);

}
