package top.mrzhao.service;

import top.mrzhao.entity.UserMeeting;

import java.util.List;

/**
 * Created by ZY on 2018/5/27.
 */
public interface UserMeetingService {
    boolean ChangeCheckStatus(Integer userId,Integer meetingId);

    boolean ChangeCheckStatusCauseByCancel(Integer meetingId);

    List<UserMeeting> SelectNotCheckByMeetingId(Integer meetingId);

    boolean InsertByMeetingIdAndDepartId(Integer meetingId , Integer departmentId);
}
