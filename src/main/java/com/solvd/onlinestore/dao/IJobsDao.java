package com.solvd.onlinestore.dao;



import com.solvd.onlinestore.model.labor.Jobs;

import java.util.List;

public interface IJobsDao extends IBaseDao<Jobs> {
    List<Jobs> getJobsByID(long id);
}
