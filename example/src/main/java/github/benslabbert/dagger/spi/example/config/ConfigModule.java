/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.config;

import dagger.Module;
import dagger.Provides;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Module
public abstract class ConfigModule {

  private ConfigModule() {}

  @Singleton
  @Provides
  @Named("external-data")
  static String externalData() {
    return "external-data";
  }
}
