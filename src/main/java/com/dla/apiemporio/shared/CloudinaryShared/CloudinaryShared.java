package com.dla.apiemporio.shared.CloudinaryShared;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.multipart.MultipartFile;

@Scope("singleton")
public class CloudinaryShared {
    @Value("${CLOUDNARY_NAME}")
    public String cloudName;
    @Value("${CLOUDINARY_API_KEY}")
    private String api_key;
    @Value("${CLOUDINARY_API_SECRET}")
    private String api_secret;

    public Cloudinary cloudinary;

    @Autowired
    public CloudinaryShared() {

    }

    private void configCloudinary() {
        Map<String, String> config = new HashMap<String, String>();
        System.out.println("Config cloudinary");
        System.out.println("Cloudnary Name" + cloudName);
        config.put("cloud_name", cloudName);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);
        cloudinary = new Cloudinary(config);
        System.out.println("Cloudinary configurado!!");
    }

    public String uploadFile(String folder, MultipartFile file) throws Exception {
        System.out.println("Uploading file: " + file.getName());
        if (cloudinary == null) {
            configCloudinary();
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("folder", folder);
        try {
            return cloudinary.uploader().upload(file.getBytes(), params).get("url").toString();
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

}
