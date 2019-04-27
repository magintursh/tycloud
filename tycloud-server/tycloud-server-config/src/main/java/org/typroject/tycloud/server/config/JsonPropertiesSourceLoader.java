package org.typroject.tycloud.server.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * code is far away from bug with the animal protecting
 * @date 2018/12/4 14:17
 * @description :  {@link PropertySourceLoader}
 *  自定义JSON格式配置文件加载
 *  启动时，通过自动加载(AutoConfiguration)对Bean进行注册
 *  在读取配置时，根据配置文件的后缀选用不同的配置文件读取方案
 **/
public class JsonPropertiesSourceLoader implements PropertySourceLoader {


    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        Map<String, ?> properties = loadJsonProperties(resource);
        if (properties.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections
                .singletonList(new OriginTrackedMapPropertySource(name, properties));
    }

    /**
     * 读取JSON格式配置文件
     * @param resource
     * @return
     */
    private Map<String, ?> loadJsonProperties(Resource resource) {
        FileInputStream is = null;
        try {
            File file = resource.getFile();
            is = new FileInputStream(file);
            JsonNode jsonNode = objectMapper.readTree(is);
            Map<String, Object> result = objectMapper.convertValue(jsonNode, Map.class);
            is.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
