package com.ym.cms.utils;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置属性文件类
 */

@Data
@Component
@ConfigurationProperties(prefix="file")
public class FileProperties {
    //虚拟路径
    private String staticAccessPath;
    //实际路径
    private String uploadFileFolder;

}