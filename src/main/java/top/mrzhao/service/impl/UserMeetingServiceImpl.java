package top.mrzhao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.dao.UserMeetingMapper;
import top.mrzhao.entity.User;
import top.mrzhao.entity.UserMeeting;
import top.mrzhao.entity.UserMeetingExample;
import top.mrzhao.service.UserMeetingService;
import top.mrzhao.service.UserService;

import java.util.List;

/**
 * Created by ZY on 2018/5/28.
 */
@Service
public class UserMeetingServiceImpl implements UserMeetingService{
    Logger logger = LoggerFactory.getLogger(UserMeetingServiceImpl.class);

    @Autowired
    UserMeetingMapper userMeetingMapper;
    @Autowired
    UserMeetingExample userMeetingExample;
    @Autowired
    UserService userService;

    @Override
    public boolean ChangeCheckStatus(Integer userId, Integer meetingId) {
        logger.info("开始更改会议查看状态。。。。。。");
        logger.info("更改会议ID为：{},会议ID为：{}",userId,meetingId);
        userMeetingExample.createCriteria().andUserIdEqualTo(userId).andMeetingIdEqualTo(meetingId);
        UserMeeting userMeeting = userMeetingMapper.selectByExample(userMeetingExample).get(0);
        userMeetingExample.clear();
        userMeeting.setStatus(1);
        if(userMeetingMapper.updateByPrimaryKeySelective(userMeeting) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean ChangeCheckStatusCauseByCancel(Integer meetingId) {
        logger.info("开始取消会议。。。。。。取消的会议ID为：{}",meetingId);
        UserMeeting userMeeting = new UserMeeting();
        userMeeting.setStatus(-1);
        userMeetingExample.createCriteria().andMeetingIdEqualTo(meetingId);
        if(userMeetingMapper.updateByExampleSelective(userMeeting,userMeetingExample) > 0){
            userMeetingExample.clear();
            return true;
        }
        userMeetingExample.clear();
        return false;
    }

    @Override
    public List<UserMeeting> SelectNotCheckByMeetingId(Integer meetingId) {
        logger.info("开始选择未通知的会议。。。。。。");
        userMeetingExample.createCriteria().andMeetingIdEqualTo(meetingId).andStatusEqualTo(0);
        List<UserMeeting> userMeetings = userMeetingMapper.selectByExample(userMeetingExample);
        userMeetingExample.clear();
        return userMeetings;
    }

    @Override
    public boolean InsertByMeetingIdAndDepartId(Integer meetingId , Integer departmentId) {
        logger.info("开始插入会议通知。。。。。。。");
        List<User> users = userService.SelectUserByDepartmentId(departmentId);
        for(User user:users){
            UserMeeting userMeeting = new UserMeeting();
            userMeeting.setUserId(user.getUserId());
            userMeeting.setMeetingId(meetingId);
            userMeeting.setStatus(0);
            userMeetingMapper.insertSelective(userMeeting);
        }
        return true;
    }
}
