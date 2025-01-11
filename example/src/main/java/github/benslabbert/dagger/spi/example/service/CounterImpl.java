/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.service;

import github.benslabbert.dagger.spi.example.repo.Repo;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
class CounterImpl implements Counter {

  private static final Logger log = LoggerFactory.getLogger(CounterImpl.class);

  private final Repo repo;

  @Inject
  CounterImpl(Repo repo) {
    this.repo = repo;
  }

  @Override
  public void count() {
    log.info("CounterImpl.count()");
  }

  @Override
  public String getData() {
    return repo.getData();
  }
}
