package com.dla.apiemporio.shared.CloudinaryShared;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class CloudinaryShared {
    @Value("${cloudnaryName}")
    public String cloudName;
    @Value("${cloudnaryApiKey}")
    private String api_key;
    @Value("${cloudnaryApiSecret}")
    private String api_secret;

    public Cloudinary cloudinary;

    @Autowired
    public CloudinaryShared() {

    }

    private void configCloudinary() {
        Map<String, String> config = new HashMap<String, String>();
        config.put("cloud_name", cloudName);
        config.put("api_key", api_key);
        config.put("api_secret", api_secret);
        cloudinary = new Cloudinary(config);
    }

    public String uploadFile(String folder, Object file) throws Exception {
        if (cloudinary == null) {
            configCloudinary();
        }
        System.out.println(api_secret);
        Map<String, String> params = new HashMap<String, String>();
        params.put("folder", folder);
        try {
            return cloudinary.uploader().upload(file, params).get("url").toString();

        } catch (IOException e) {
            throw new Exception(e);
        }
    }

}
