package com.user.common.utils.web;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	/**
	 * http post方法
	 * 
	 * @param url
	 *            地址
	 * @param jsonStrData
	 *            json数据
	 * @param params
	 *            设置soketOut,connOut,Authorization 对应http的超时时间和授权
	 * @return Map<String,
	 *         String>,(key=status,value返回success或fail),(key=data,value返回http响应数据)
	 */
	public Map<String, String> postJsonData(String url, String jsonStrData, HashMap<String, Object> params) {
		HttpPost post = new HttpPost(url);
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			Integer soketOut = 20000;
			Integer connOut = 20000;
			if (params != null) {
				if (params.containsKey("soketOut")) {
					soketOut = Integer.valueOf(params.get("soketOut") + "");
				}
				if (params.containsKey("connOut")) {
					connOut = Integer.valueOf(params.get("connOut") + "");
				}
				if (params.containsKey("Authorization")) {
					post.setHeader("Authorization", params.get("Authorization") + "");
				}
			}
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(soketOut).setConnectTimeout(connOut)
					.build();// 设置请求和传输超时时间
			post.setConfig(requestConfig);
			HttpEntity entity = new StringEntity(jsonStrData, "UTF-8");
			post.setEntity(entity);
			post.setHeader("Content-type", "application/json");
			HttpResponse resp = closeableHttpClient.execute(post);
			InputStream respIs = resp.getEntity().getContent();
			byte[] respBytes = IOUtils.toByteArray(respIs);
			String result = new String(respBytes, Charset.forName("UTF-8"));
			if (result.length() == 0 || resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				resultMap.put("status", "fail");
				logger.error("HttpUtils postJsonData 响应错误,请求参数=url=" + url + ",jsonStr=" + jsonStrData + ",params="
						+ JSONObject.toJSONString(params) + ",result=" + result);
			} else {
				resultMap.put("status", "success");
			}
			resultMap.put("data", result);
		} catch (IOException e) {
			resultMap.put("status", "fail");
			logger.error("HttpUtils postJsonData" + e.getMessage() + "请求参数=url=" + url + ",jsonStr=" + jsonStrData
					+ ",params=" + JSONObject.toJSONString(params), e);
		}
		return resultMap;
	}

	/**
	 * 32 * 测试发送GET请求 33
	 */
	public Map<String, String> get(String url) {
		// 1. 创建一个默认的client实例
		CloseableHttpClient client = HttpClients.createDefault();
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			// 2. 创建一个httpget对象
			HttpGet httpGet = new HttpGet(url);
			System.out.println("executing GET request " + httpGet.getURI());

			// 3. 执行GET请求并获取响应对象
			HttpResponse resp = client.execute(httpGet);
			InputStream respIs = resp.getEntity().getContent();
			byte[] respBytes = IOUtils.toByteArray(respIs);
			String result = new String(respBytes, Charset.forName("UTF-8"));
			if (result.length() == 0 || resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				resultMap.put("status", "fail");
				logger.error("HttpUtils get 响应错误,请求参数=url=" + url + ",result=" + result);
			} else {
				resultMap.put("status", "success");
			}
			resultMap.put("data", result);

		} catch (IOException e) {
			e.printStackTrace();
			resultMap.put("status", "fail");
			logger.error("HttpUtils postJsonData" + e.getMessage() + "请求参数=url=" + url, e);
			return resultMap;
		} finally {
			// 8. 最终要关闭连接，释放资源
			try {
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}

	/**
	 * get请求传输数据
	 *
	 * @param url
	 * @param encoding
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String sendGetData(String url, String encoding) throws ClientProtocolException, IOException {
		String result = "";

		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建get方式请求对象
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-type", "application/json");
		// 通过请求对象获取响应对象
		CloseableHttpResponse response = httpClient.execute(httpGet);

		// 获取结果实体
		// 判断网络连接状态码是否正常(0--200都数正常)
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result = EntityUtils.toString(response.getEntity(), "utf-8");
		}
		// 释放链接
		response.close();

		return result;
	}
}
