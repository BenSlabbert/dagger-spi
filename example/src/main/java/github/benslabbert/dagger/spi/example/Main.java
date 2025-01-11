/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example;

import github.benslabbert.dagger.spi.example.di.DaggerProvider;
import github.benslabbert.dagger.spi.example.di.Provider;
import github.benslabbert.dagger.spi.example.service.Counter;
import github.benslabbert.dagger.spi.example.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    log.info("Hello World");
    Provider provider = DaggerProvider.builder().name("name").build();
    provider.init();

    Counter counter = provider.counter();
    counter.count();
    String data = counter.getData();
    log.info("data: {}", data);

    EchoService echoService = provider.echoService();
    echoService.echo();
  }
}
