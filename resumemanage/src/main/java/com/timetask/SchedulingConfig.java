package com.timetask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.utils.LoggerUtil;


/**
 * 定时任务配置类
 *
 */
//@Configuration
//@EnableScheduling // 启用定时任务
public class SchedulingConfig {

	Logger logger = LoggerFactory.getLogger(SchedulingConfig.class);

	    @Scheduled(cron = "0/3 * * * * ?") // 每20秒执行一次
	    public void scheduler() {
	    	LoggerUtil.info(logger, "");
	        logger.info(">>>>>>>>>>>>> scheduled ... ");
	    }
	    
	    @Scheduled(cron = "0/2 * * * * ?") // 每20秒执行一次
	    public void scheduler1() {
	    	LoggerUtil.info(logger, "");
	        logger.info(">>>>>>>>>>>>> scheduled1 ... ");
	    }

	
}
