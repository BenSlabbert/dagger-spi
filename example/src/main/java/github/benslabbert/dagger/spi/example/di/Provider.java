/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.di;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import github.benslabbert.dagger.spi.example.config.ConfigModule;
import github.benslabbert.dagger.spi.example.repo.RepoModule;
import github.benslabbert.dagger.spi.example.service.Counter;
import github.benslabbert.dagger.spi.example.service.EchoService;
import github.benslabbert.dagger.spi.example.service.ServiceModule;
import jakarta.annotation.Nullable;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Component(
    modules = {
      Provider.EagerModule.class,
      ServiceModule.class,
      RepoModule.class,
      ConfigModule.class
    })
public interface Provider {

  @Nullable Void init();

  Counter counter();

  EchoService echoService();

  @Component.Builder
  interface Builder {
    @BindsInstance
    Builder name(@Named("name") String name);

    Provider build();
  }

  @Module
  final class EagerModule {

    private static final Logger log = LoggerFactory.getLogger(EagerModule.class);

    @Inject
    EagerModule() {}

    @Provides
    @Nullable static Void provideEager() {
      // this eagerly builds any parameters specified and returns nothing
      log.info("init");
      return null;
    }
  }
}
