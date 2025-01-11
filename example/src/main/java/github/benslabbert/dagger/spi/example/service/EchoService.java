/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.service;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class EchoService {
  private static final Logger log = LoggerFactory.getLogger(EchoService.class);

  private final String name;
  private final String externalData;

  @Inject
  EchoService(@Named("name") String name, @Named("external-data") String externalData) {
    this.name = name;
    this.externalData = externalData;
  }

  public void echo() {
    log.info("Echo: {} : {}", name, externalData);
  }
}
