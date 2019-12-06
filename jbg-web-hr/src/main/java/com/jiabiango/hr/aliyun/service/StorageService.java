package com.jiabiango.hr.aliyun.service;

import java.io.File;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;

/** * @author   XuHongrong 
    * @date 	创建时间：2018年1月9日 上午9:48:12 
	* @version 1.0 
	*/

public interface StorageService {
	
	/**
	 * 获取阿里云OSS客户端对象 
	 * @param endPoint
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @return
	 */
	public OSSClient getOSSClient(String endPoint, String accessKeyId, String accessKeySecret);
	
	/**
	 * 创建存储空间 
	 * @param ossClient  OSS连接 
	 * @param bucketName
	 * @return
	 */
	public  String createBucketName(OSSClient ossClient,String bucketName);
	
	/**
	 * 删除存储空间buckName 
	 * @param ossClient  oss连接 
	 * @param bucketName
	 */
	public void deleteBucket(OSSClient ossClient, String bucketName);
	
	/**
	 * 创建模拟文件夹 
	 * @param ossClient oss连接 
	 * @param bucketName  存储空间 
	 * @param folder  模拟文件夹名如"qj_nanjing/" 
	 * @return  文件夹名 
	 */
	public  String createFolder(OSSClient ossClient,String bucketName,String folder);
	
	/**
	 * 根据key删除OSS服务器上的文件   
	 * @param ossClient  oss连接 
	 * @param bucketName  存储空间 
	 * @param folder  模拟文件夹名如"qj_nanjing/" 
	 * @param key  Bucket下的文件的路径名+文件名 如："upload/cake.jpg" 
	 */
	public void deleteFile(OSSClient ossClient, String bucketName, String folder, String key);
	
	/**
	 * 上传图片至OSS 
	 * @param ossClient oss连接 
	 * @param file 上传文件（文件全路径如：D:\\image\\cake.jpg） 
	 * @param bucketName 存储空间 
	 * @param folder 模拟文件夹名 如"qj_nanjing/" 
	 * @param fileName 文件名
	 * @return  返回的唯一MD5数字签名 
	 */
	public String uploadObject2OSS(OSSClient ossClient, File file, String bucketName, 
			String folder, String fileName); 
	
	public String uploadObject2OSS2(OSSClient ossClient, MultipartFile file, String bucketName, 
			String folder, String fileName);

	String uploadObject2OSS3(OSSClient ossClient, InputStream file, String bucketName, String folder, String fileName,long length); 


	

}
