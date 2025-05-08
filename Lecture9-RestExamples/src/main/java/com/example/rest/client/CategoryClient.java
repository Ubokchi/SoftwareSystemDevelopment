package com.example.rest.client;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.rest.domain.Category;
import com.example.rest.domain.Product;

public class CategoryClient {

	private static RestTemplate restTemplate = new RestTemplate();
	private static String host = "localhost";
	private static String port = "8080";
	private static String categorySvcUrl = "http://" + host + ":" + port + "/category";				

	public static void main(String[] args) {
		simpleGet("https://cs.dongduk.ac.kr/");

		// test getCategory
		getForObjectByVariableArg("101", "102");
		getForObjectByVariableMap("103");

		// test createCategory
		Category category = new Category();
		category.setCategoryId("104");
		category.setName("Hamster");
		category.setDescription("햄스터");
		String newCategoryUri = postForLocation(category);
		
		category = restTemplate.getForObject(newCategoryUri, Category.class);
		System.out.println("get the new category by URI: " + category);
		
		// test updateCategory
		put("104", "GuineaPig", "기니피그");
		category = restTemplate.getForObject(newCategoryUri, Category.class);
		System.out.println("get the new category by URI: " + category);
		
		// test deleteCategory
		delete("104");
		
		// test getProduct by using RestTemplate.exchange()
		exchange1();
		
		// test createCategory by using RestTemplate.exchange()
		exchange2();
	}

	private static void simpleGet(String url) {
		System.out.println("\n[simpleGet]");
		String body = restTemplate.getForObject(url, String.class);
		System.out.println(body);
	}

	private static void getForObjectByVariableArg(String catId1, String catId2) {
		System.out.println("\n[getForObjectByVariableArg]");
		String response = restTemplate.getForObject(
				categorySvcUrl + "/{categoryId}", String.class, catId1); 
		System.out.println("Response as a string: " + response);
		Category category = restTemplate.getForObject(
				categorySvcUrl + "/{categoryId}", Category.class, catId2);
		System. out.println("Response as an object: " + category);
	}

	private static void getForObjectByVariableMap(String catId) {
		System.out.println("\n[getForObjectByVariableMap]");
		Map<String, Object> pathVariableMap = new HashMap<>();
		pathVariableMap.put("categoryId", catId);

		Category category2 = restTemplate.getForObject(
				categorySvcUrl + "/{categoryId}",
				Category.class,
				pathVariableMap);
		System.out.println("Response as an object: " + category2);
	}

	private static String postForLocation(Category category) {
		System.out.println("\n[postForLocation]");
		URI uri = restTemplate.postForLocation(categorySvcUrl, category);
		String uriStr = uri.toString();		
		System.out.println(category + " created.");
		System.out.println("New Category URI: " + uriStr);
		return uriStr;
	}

	private static void put(String catId, String name, String desc) {
		System.out.println("\n[put]");
		Category category = new Category();
		category.setCategoryId(catId);
		category.setName(name);
		category.setDescription(desc);
		restTemplate.put(categorySvcUrl + "/{categoryId}", category, category.getCategoryId());
		System.out.println(category + " updated.");
	}
	
	private static void delete(String catId) {
		System.out.println("\n[delete]");
		restTemplate.delete(categorySvcUrl + "/{categoryId}", catId);
		System.out.println("category " + catId + " deleted.");
	}
		
	private static void exchange1() {
		System.out.println("\n[exchange]");

		// getForEntity를 exchange를 이용해서 구현한 코드
		URI uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host(host)
				.port(port)
				.path("/category/{categoryId}/product/{productId}")
				.build()
				.expand("101", "PT").encode()
				.toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.add("AUTHKEY", "mykey");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

		ResponseEntity<Product> itemResponse = restTemplate.exchange(
				uri, 
				HttpMethod.GET, 
				requestEntity, 
				Product.class);
		Product product = itemResponse.getBody();
		System.out.println("Response as an object: " + product);
	}
	
	private static void exchange2() {
		System.out.println("\n[exchange]");

		// postForLocation을 exchange를 이용해서 구현한 코드
		Category category = new Category();
		category.setCategoryId("105");
		category.setName("Snake");
		category.setDescription("뱀");
		
		HttpEntity<Category> requestEntity = new HttpEntity<>(category);

		ResponseEntity<Void> postResponse = restTemplate.exchange(
				categorySvcUrl, 
				HttpMethod.POST, 
				requestEntity, 
				Void.class);
		URI newCategoryUri = postResponse.getHeaders().getLocation();
		System.out.println(category + " created.");
		System.out.println("New Category URI: " + newCategoryUri);		
	}
}
