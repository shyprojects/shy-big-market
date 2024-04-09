package cn.shy.infrastructure.persistent.repository;

import cn.shy.domain.task.model.entity.TaskEntity;
import cn.shy.domain.task.repository.ITaskRepository;
import cn.shy.infrastructure.event.EventPublisher;
import cn.shy.infrastructure.persistent.dao.ITaskDao;
import cn.shy.infrastructure.persistent.po.Task;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shy
 * @since 2024/4/8 19:36
 */
@Repository
public class TaskRepository implements ITaskRepository {
    
    @Resource
    private ITaskDao taskDao;
    
    @Resource
    private EventPublisher eventPublisher;
    
    
    @Override
    public List<TaskEntity> queryNoSendMessageTaskList() {
        List<Task> tasks = taskDao.queryNoSendMessageTaskList();
        List<TaskEntity> taskEntities = new ArrayList<>(tasks.size());
        for (Task task : tasks) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setUserId(task.getUserId());
            taskEntity.setTopic(task.getTopic());
            taskEntity.setMessageId(task.getMessageId());
            taskEntity.setMessage(task.getMessage());
            taskEntities.add(taskEntity);
        }
        return taskEntities;
    }
    
    @Override
    public void sendMessage(TaskEntity taskEntity) {
        eventPublisher.publish(taskEntity.getTopic(),taskEntity.getMessage());
    }
    
    @Override
    public void updateTaskSendMessageCompleted(String userId, String messageId) {
        Task taskReq = new Task();
        taskReq.setUserId(userId);
        taskReq.setMessageId(messageId);
        taskDao.updateTaskSendMessageCompleted(taskReq);
    }
    
    @Override
    public void updateTaskSendMessageFail(String userId, String messageId) {
        Task taskReq = new Task();
        taskReq.setUserId(userId);
        taskReq.setMessageId(messageId);
        taskDao.updateTaskSendMessageFail(taskReq);
    }
}
