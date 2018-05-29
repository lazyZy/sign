package top.mrzhao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.dao.MeetingMapper;
import top.mrzhao.entity.Meeting;
import top.mrzhao.entity.MeetingExample;
import top.mrzhao.service.MeetingService;
import top.mrzhao.service.UserMeetingService;
import top.mrzhao.util.BaseResult;

import java.util.Date;
import java.util.List;

/**
 * Created by ZY on 2018/5/28.
 */
@Service
public class MeetingServiceImpl implements MeetingService{
    Logger logger = LoggerFactory.getLogger(MeetingServiceImpl.class);

    @Autowired
    MeetingMapper meetingMapper;
    @Autowired
    MeetingExample meetingExample;
    @Autowired
    UserMeetingService userMeetingService;

    @Override
    public BaseResult SelectMeetingByStatus(Integer meetingStatus) {
        logger.info("开始通过状态选择会议。。。。。。。");
        meetingExample.createCriteria().andMeetingStatusEqualTo(meetingStatus);
        List<Meeting> meetings = meetingMapper.selectByExample(meetingExample);
        meetingExample.clear();
        return BaseResult.create(200,meetings,"获取数据成功");
    }

    @Override
    public List<Meeting> SelectMeetingByStatusAndTime() {
        meetingExample.createCriteria().andMeetingStatusEqualTo(1).andMeetingTimeGreaterThanOrEqualTo(new Date(new Date().getTime()+ 600000));
        List<Meeting> meetings = meetingMapper.selectByExample(meetingExample);
        meetingExample.clear();
        return meetings;
    }

    @Override
    public BaseResult SelectMeetingByMeetingId(Integer meetingId) {
        logger.info("开始获取会议信息通过会议ID。。。。。。。");
        Meeting meeting = meetingMapper.selectByPrimaryKey(meetingId);
        return BaseResult.create(200,meeting,"获取会议信息成功");
    }

    @Override
    public boolean InsertMeeting(Meeting meeting) {
        logger.info("开始插入会议信息。。。。。");
        logger.info("会议信息为：{}",meeting);
        Integer meetingId = meetingMapper.insertSelective(meeting);
        if(meetingId > 0 && userMeetingService.InsertByMeetingIdAndDepartId(meetingId,meeting.getMeetingDepartmentId())){
            return true;
        }
        return false;
    }

    @Override
    public boolean CancelMeeting(Integer meetingId) {
        logger.info("开始取消会议。。。。。。");
        logger.info("取消的会议ID为：{}",meetingId);
        Meeting meeting = meetingMapper.selectByPrimaryKey(meetingId);
        meeting.setMeetingStatus(-1);
        if(meetingMapper.updateByPrimaryKey(meeting) > 0){
            return true;
        }
        return false;
    }

    @Override
    public BaseResult UpdateMeeting(Meeting meeting) {
        logger.info("开始更新会议信息。。。。。。。");
        logger.info("更新的会议信息为：{}",meeting);
        if(meetingMapper.updateByPrimaryKeySelective(meeting) > 0 ){
            return BaseResult.create(200,null,"更新成功");
        }
        return BaseResult.createBadRequest();
    }
}
