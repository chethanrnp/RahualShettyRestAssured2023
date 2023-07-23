package ECommerceAPITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class EndToEndTest {

	@Test
	public void endEndTest() {
		// creating the request specbuilder
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).log(LogDetail.BODY).build();
		// creating login Request object
		LoginRequest_Payload login = new LoginRequest_Payload("chethan.supernova@gmail.com", "Chethan@17");
		// creating login request and fetching loginID and Token
		RequestSpecification reqLogin = given().spec(req).body(login);
		LoginResponse_Payload loginResponse = reqLogin.post("/api/ecom/auth/login").then().log().all().extract()
				.response().as(LoginResponse_Payload.class);
		// storing loginId And token in a variable
		String token = loginResponse.getToken();
		String userID = loginResponse.getUserId();
		// add Product
		RequestSpecification addProducrBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).log(LogDetail.BODY).build();
		// creating request for add product
		RequestSpecification reqAddProduct = given().spec(addProducrBaseReq).param("productName", "LENAVO")
				.param("productAddedBy", userID).param("productCategory", "Study").param("productSubCategory", "Laptop")
				.param("productPrice", "11500").param("productDescription", "HP original").param("productFor", "ALL")
				.multiPart("productImage", new File(System.getProperty("user.dir") + ".\\Image\\Pan_card.jpg"));
		// fetching the ProductID from the response
		String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product").then().log().all()
				.extract().response().asString();
		// creating JSON path to convert string to JSON
		JsonPath js = new JsonPath(addProductResponse);
		// getting the Added productID from the respponse
		String addProductID = js.get("productId");
		// Create order
		// creating object of order
		Orders order = new Orders("India", addProductID);
		ArrayList<Orders> array = new ArrayList<Orders>();
		array.add(order);
		// creating object of CreatOrderPayload
		CreateOrder_Payload createOrderBody = new CreateOrder_Payload(array);
		// creating the request specbuilder
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).log(LogDetail.BODY).build();
		RequestSpecification createOrderReq = given().spec(createOrderBaseReq).body(createOrderBody);
		// converting response to string
		String responseCreateOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all()
				.extract().response().asString();
		System.out.println(responseCreateOrder);

		// delete the product
		// creating the request specbuilder
		RequestSpecification deleteOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).setContentType(ContentType.JSON).log(LogDetail.BODY).build();
		RequestSpecification deleteOrderReq = given().spec(deleteOrderBaseReq).pathParam("productId",
				order.getProductOrderedId());
		String deleteResponse = deleteOrderReq.when().delete("/api/ecom/product/delete-product/{productId}").then()
				.log().all().extract().response().asString();
		System.out.println(deleteResponse);
		// validating the delete response
		Assert.assertEquals(new JsonPath(deleteResponse).getString("message"), "Product Deleted Successfully");
	}
}
