package com.solvd.onlinestore.services.interfaces;

import com.solvd.onlinestore.model.labor.Jobs;

public interface IJobsService<T> {
    Jobs getJobsById(long id);
}
