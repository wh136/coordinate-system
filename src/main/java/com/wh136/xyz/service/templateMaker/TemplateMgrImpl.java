package com.wh136.xyz.service.templateMaker;


import com.wh136.xyz.dto.AthenaComposeServiceDTO;
import com.wh136.xyz.dto.AthenaServiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.annotation.Resource;
import javax.lang.model.element.TypeElement;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@Slf4j
public class TemplateMgrImpl implements TemplateMgr {
    String oldString = "oldString";
    String newString = "newString";

    private String targetFile = "src/main/resources/DeployTemplate/docker-compose.yml";


    @Override
    public void replaceWordInFile() {
//        Constructor constructor = new Constructor(AthenaComposeServiceDTO.class);
//        TypeDescription type = new TypeDescription(AthenaComposeServiceDTO.class);
//        type.addPropertyParameters("services", String.class, Map.class);
//        //type.addPropertyParameters("athena-eureka", String.class, AthenaComposeServiceDTO.class);
//        constructor.addTypeDescription(type);
//        Yaml yaml = new Yaml(constructor);
        Yaml yaml = new Yaml();
        LinkedHashMap services = new LinkedHashMap();
        try {
            for(Object data: yaml.loadAll(new FileReader(targetFile))) {
//                AthenaComposeServiceDTO athenaComposeServiceDTO = (AthenaComposeServiceDTO) data;
//                AthenaServiceDTO athenaServiceDTO = athenaComposeServiceDTO.getServices();
//                System.out.println(athenaServiceDTO.getImage());
//                Map<String, AthenaServiceDTO> athenaServiceDTO = athenaComposeServiceDTO.getServices();
//                AthenaServiceDTO service = athenaServiceDTO.get("athena-eureka");
//                System.out.println("image Name:" + service.getImage());
                LinkedHashMap<String, LinkedHashMap<String, Object>> linkedHashMap = (LinkedHashMap)data;
                services = linkedHashMap.get("services");
            }
            LinkedHashMap athenaHomework = (LinkedHashMap) services.get("athena-homework");
            ArrayList volumes = (ArrayList)athenaHomework.get("volumes");
            volumes.add("xxx:xxxx");
            athenaHomework.replace("volumes", volumes);
            log.info(athenaHomework.toString());
            services.replace("athena-homework",athenaHomework);
            yaml.dump(services, new FileWriter("src/main/resources/DeployTemplate/docker-compose-test.yml"));


//            AthenaComposeServiceDTO o = yaml.loadAs(new FileInputStream(new File(targetFile)), AthenaComposeServiceDTO.class);
//            log.info(o.toString());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        TemplateMgrImpl mgr = new TemplateMgrImpl();
        mgr.replaceWordInFile();
    }

}
