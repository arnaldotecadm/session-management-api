package br.com.emerion.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping(path = "/auth")
public class AuthController {
	
	@Value("${user_webservice.host}")
	private String host;
	
	@Value("${user_webservice.port}")
	private String port;
	
	@Value("${user_webservice.context}")
	private String context;
	
	public static void main(String[] args) throws IOException {
		ResponseEntity<String> authResponse = new AuthController()
				.post("http://localhost:8080/user-management/authenticate", 
						new Gson().toJson(new IdentificacaoUsuario("javainuse", "password","")));
		
		String body = authResponse.getBody();
		if(authResponse.getStatusCodeValue() == 200) {
			JSONObject jsonObject = new JSONObject(body);
			System.out.println("Valor do Token: " + jsonObject.getString("token"));
		} else {
			System.out.println("A requisição não foi bem sucedida!!!");
			System.out.println(body);
		}
	}

	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

	@ApiOperation(value = "Ping para resposta do Servidor")
	@GetMapping(value = "/ping", produces = "application/json")
	@ResponseBody
	public String hi() {
		return "ok.";
	}

	@ApiOperation(value = "Logar no sistema de exceções e recuperar um token JWT válido.")
	@PostMapping(value = "login")
	public ResponseEntity<String> checkPermission(@RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("publicKey") String publicKey)
			throws NoSuchAlgorithmException, IOException {

		return new AuthController()
				.post(this.host + ":" + this.port + "/" + this.context + "/authenticate", 
						new Gson().toJson(new IdentificacaoUsuario(userName, password,"")));
	}

	ResponseEntity<String> post(String url, String json) throws IOException {
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(json, JSON);
		Request request = new Request.Builder().url(url).post(body).build();
		try (Response response = client.newCall(request).execute()) {
			return new ResponseEntity<String>(response.body().string(), HttpStatus.resolve(response.code()));
		}
	}

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class IdentificacaoUsuario {
	private String username;
	private String password;
	private String software;
}
