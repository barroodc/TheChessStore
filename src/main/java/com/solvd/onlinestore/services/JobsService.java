package com.solvd.onlinestore.services;

import com.solvd.onlinestore.dao.jdbcmySQLImpl.JobsDao;
import com.solvd.onlinestore.model.labor.Jobs;
import com.solvd.onlinestore.services.interfaces.IJobsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JobsService implements IJobsService<Jobs> {
    private static final Logger LOGGER = LogManager.getLogger(JobsService.class);
    private static final JobsDao jobsDao;
    private static Jobs jobs;

    static {
        jobsDao = new JobsDao();
        jobs = null;
    }

    @Override
    public Jobs getJobsById(long id) {
        try {
            jobs = (Jobs) jobsDao.getJobsByID(id);
            LOGGER.info(jobs);
        } catch (Exception e){
            LOGGER.error(e);
        }
        return null;
    }
}
