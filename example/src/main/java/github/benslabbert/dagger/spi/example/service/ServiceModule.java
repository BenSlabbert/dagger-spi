/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.service;

import dagger.Module;

@Module(includes = {ModuleBindings.class})
public interface ServiceModule {

  EchoService provideEchoService();

  Counter provideCounter();
}
