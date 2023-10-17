package com.lixuan.constant;

/**
 * redis通道名称
 */
public enum RedisTopicEnums {
    TOPIC_DTC("JsonCommandToLocalDTC", "雷达预处理服务通道"),


    TOPIC_PVMS("JsonCommandToPVMS", "pvms服务通道");
    /**
     * 主题名称
     */
    private String topic;

    /**
     * 描述
     */
    private String description;

    RedisTopicEnums(String topic, String description) {
        this.topic = topic;
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

}
