package com.bcgdv.benchmark.resources;

import com.bcgdv.benchmark.entities.Country;
import com.bcgdv.benchmark.repositories.CountryRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Getter
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/tests")
public class TestsController {

  @Autowired
  private final RestTemplate restTemplate;
  @Autowired
  private final CountryRepository countryRepository;

  private final String text = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

  @GetMapping(path = "/hash", produces = MediaType.TEXT_PLAIN_VALUE)
  public String hash() {
    MessageDigest cryptograph = null;
    StringBuilder builder = new StringBuilder();
    try {
      cryptograph = MessageDigest.getInstance("SHA-1");
      cryptograph.reset();
      cryptograph.update(text.getBytes(StandardCharsets.UTF_8));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    byte[] bytes = Optional.ofNullable(cryptograph).map(crypto -> crypto.digest())
        .orElse(new byte[0]);

    for (byte bits : bytes) {
      builder.append(String.format("%02x", bits));
    }

    return builder.toString();
  }

  @GetMapping(path = "/google", produces = MediaType.TEXT_PLAIN_VALUE)
  public String google() {
    return restTemplate.getForObject("http://google.com", String.class);
  }

  @GetMapping(path = "/geography", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Country> geography() {
    return this.countryRepository.findAll();
  }

  @GetMapping(path = "/journal", produces = MediaType.TEXT_PLAIN_VALUE)
  public String journal() {
    Path path = Paths.get("/tmp/lorem_ipsum.txt");
    StringBuilder stringBuilder = new StringBuilder();

    try (BufferedWriter writer = Files
        .newBufferedWriter(path,
            Charset.forName("UTF-8"))) {
      writer.write(text);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (BufferedReader reader = Files
        .newBufferedReader(path, Charset.forName("UTF-8"))) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return stringBuilder.toString();
  }
}
