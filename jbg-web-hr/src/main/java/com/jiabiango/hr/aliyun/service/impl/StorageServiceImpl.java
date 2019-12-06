package com.jiabiango.hr.aliyun.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.jiabiango.hr.aliyun.service.StorageService;

/** * @author   XuHongrong 
    * @date 	创建时间：2017年11月1日 下午4:13:30 
	* @version 1.0 
	*/
@Service("StorageService")
public class StorageServiceImpl implements StorageService {
	
	//log日志  
    private static Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);  

	@Override
    public OSSClient getOSSClient(String endPoint, String accessKeyId, String accessKeySecret){  
        return new OSSClient(endPoint, accessKeyId, accessKeySecret);  
    }  
  
	@Override
    public  String createBucketName(OSSClient ossClient,String bucketName){  
        //存储空间  
        final String bucketNames=bucketName;  
        if(!ossClient.doesBucketExist(bucketName)){  
            //创建存储空间  
            Bucket bucket=ossClient.createBucket(bucketName);  
            logger.info("创建存储空间成功");  
            return bucket.getName();  
        }  
        return bucketNames;  
    }  
      
	@Override
    public void deleteBucket(OSSClient ossClient, String bucketName){    
        ossClient.deleteBucket(bucketName);     
        logger.info("删除" + bucketName + "Bucket成功");    
    }    
      
	@Override
    public  String createFolder(OSSClient ossClient,String bucketName,String folder){  
        //文件夹名   
        final String keySuffixWithSlash =folder;  
        //判断文件夹是否存在，不存在则创建  
        if(!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)){  
            //创建文件夹  
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));  
            logger.info("创建文件夹成功");  
            //得到文件夹名  
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);  
            String fileDir=object.getKey();  
            return fileDir;  
        }  
        return keySuffixWithSlash;  
    }  
      
	@Override 
   public void deleteFile(OSSClient ossClient, String bucketName, String folder, String key){      
        ossClient.deleteObject(bucketName, folder + key);     
        logger.info("删除" + bucketName + "下的文件" + folder + key + "成功");    
   }   
      
	@Override 
    public String uploadObject2OSS(OSSClient ossClient, File file, 
    		String bucketName, String folder, String fileName) {  
        String resultStr = null;  
        try {  
            //以输入流的形式上传文件  
            InputStream is = new FileInputStream(file);  
            //文件大小  
            Long fileSize = file.length();   
            //创建上传Object的Metadata    
            ObjectMetadata metadata = new ObjectMetadata();  
            //上传的文件的长度  
            metadata.setContentLength(is.available());    
            //指定该Object被下载时的网页的缓存行为  
            metadata.setCacheControl("no-cache");   	
            //指定该Object下设置Header  
            metadata.setHeader("Pragma", "no-cache");    
            //指定该Object被下载时的内容编码格式  
            metadata.setContentEncoding("utf-8");    
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，  
            //如果没有扩展名则填默认值application/octet-stream  
            metadata.setContentType(getContentType(fileName));    
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）  
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");    
            //上传文件   (上传文件流的形式)  
            String key = folder + "/" +  fileName;
            PutObjectResult putResult = ossClient.putObject(bucketName, key, is, metadata);    
            ossClient.shutdown();
            resultStr = putResult.getETag();
//            logger.info("上传阿里云OSS,bucketName={},key={},meatadata={}",bucketName,key,JsonUtil.toJson(metadata));  
        } catch (Exception e) {  
             logger.error("上传阿里云OSS服务器异常.", e);    
             throw new RuntimeException("上传阿里云OSS服务器异常");
        }  
        return resultStr;  
    }  
  
    /** 
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType 
     * @param fileName 文件名 
     * @return 文件的contentType 
     */  
    private String getContentType(String fileName){  
        //文件的后缀名  
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));  
        if(".bmp".equalsIgnoreCase(fileExtension)) {  
            return "image/bmp";  
        }  
        if(".gif".equalsIgnoreCase(fileExtension)) {  
            return "image/gif";  
        }  
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {  
            return "image/jpeg";  
        }  
        if(".html".equalsIgnoreCase(fileExtension)) {  
            return "text/html";  
        }  
        if(".txt".equalsIgnoreCase(fileExtension)) {  
            return "text/plain";  
        }  
        if(".vsd".equalsIgnoreCase(fileExtension)) {  
            return "application/vnd.visio";  
        }  
        if(".ppt".equalsIgnoreCase(fileExtension) ) {  
            return "application/vnd.ms-powerpoint";  
        }  
        if("pptx".equalsIgnoreCase(fileExtension)) {  
        	return "application/vnd.openxmlformats-officedocument.presentationml.presentation";  
        }  
        if(".doc".equalsIgnoreCase(fileExtension) ) {  
            return "application/msword";  
        }  
        if(".docx".equalsIgnoreCase(fileExtension) ) {  
        	return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";  
        }  
        if(".xml".equalsIgnoreCase(fileExtension)) {  
            return "text/xml";  
        }  
        if(".apk".equalsIgnoreCase(fileExtension)) {  
        	return "application/vnd.android";  
        }  
        if(".jar".equalsIgnoreCase(fileExtension)) {  
        	return "application/java-archive";  
        }  
        if(".war".equalsIgnoreCase(fileExtension)) {  
        	return "application/java-archive";  
        }  
        if(".zip".equalsIgnoreCase(fileExtension)) {  
        	return "application/zip";  
        }  
        if(".rar".equalsIgnoreCase(fileExtension)) {  
        	return "application/x-rar-compressed";  
        }  
        if(".xls".equalsIgnoreCase(fileExtension)) {  
        	return "application/vnd.ms-excel";  
        }  
        if(".xlsx".equalsIgnoreCase(fileExtension)) {  
        	return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";  
        }  
        if(".exe".equalsIgnoreCase(fileExtension)) {  
        	return "application/octet-stream";  
        }  
        
        //默认返回类型  
        return "image/jpeg";  
    }

	@Override
	public String uploadObject2OSS2(OSSClient ossClient, MultipartFile file, String bucketName, String folder,
			String fileName) {
		 String resultStr = null;  
	        try {  
	            //以输入流的形式上传文件  
	            InputStream is = file.getInputStream();  
	            //文件大小  
	            Long fileSize = file.getSize();   
	            //创建上传Object的Metadata    
	            ObjectMetadata metadata = new ObjectMetadata();  
	            //上传的文件的长度  
	            metadata.setContentLength(is.available());    
	            //指定该Object被下载时的网页的缓存行为  
	            metadata.setCacheControl("no-cache");   	
	            //指定该Object下设置Header  
	            metadata.setHeader("Pragma", "no-cache");    
	            //指定该Object被下载时的内容编码格式  
	            metadata.setContentEncoding("utf-8");    
	            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，  
	            //如果没有扩展名则填默认值application/octet-stream  
	            metadata.setContentType(getContentType(fileName));    
	            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）  
	            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");    
	            //上传文件   (上传文件流的形式)  
	            String key = folder + "/" +  fileName;
	            PutObjectResult putResult = ossClient.putObject(bucketName, key, is, metadata);    
	            ossClient.shutdown();
	            resultStr = putResult.getETag();
	            logger.info("上传阿里云OSS,bucketName={},key={},meatadata={}",bucketName,key,metadata);
	        } catch (Exception e) {  
	             logger.error("上传阿里云OSS服务器异常.", e);
	             throw new RuntimeException("上传阿里云OSS服务器异常");
	        }  
	        return resultStr;
	}  
	
	// H5
	@Override
	public String uploadObject2OSS3(OSSClient ossClient, InputStream is, String bucketName, String folder,
			String fileName,long fileSize) {
		String resultStr = null;  
		try {  
			//以输入流的形式上传文件  
			//InputStream is = file.getInputStream();  
			//文件大小  
			//Long fileSize = file.getSize();   
			//创建上传Object的Metadata    
			ObjectMetadata metadata = new ObjectMetadata();  
			//上传的文件的长度  
			metadata.setContentLength(is.available());    
			//指定该Object被下载时的网页的缓存行为  
			metadata.setCacheControl("no-cache");   	
			//指定该Object下设置Header  
			metadata.setHeader("Pragma", "no-cache");    
			//指定该Object被下载时的内容编码格式  
			metadata.setContentEncoding("utf-8");    
			//文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，  
			//如果没有扩展名则填默认值application/octet-stream  
			metadata.setContentType(getContentType(fileName));    
			//指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）  
			metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");    
			//上传文件   (上传文件流的形式)  
			String key = folder + "/" +  fileName;
			PutObjectResult putResult = ossClient.putObject(bucketName, key, is, metadata);    
			ossClient.shutdown();
			resultStr = putResult.getETag();
			logger.info("上传阿里云OSS,bucketName={},key={},meatadata={}",bucketName,key,metadata);
		} catch (Exception e) {  
			logger.error("上传阿里云OSS服务器异常.", e);
			throw new RuntimeException("上传阿里云OSS服务器异常");
		}  
		return resultStr;
	}  
}
