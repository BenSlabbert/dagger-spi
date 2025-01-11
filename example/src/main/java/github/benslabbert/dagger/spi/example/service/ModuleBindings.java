/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.service;

import dagger.Binds;
import dagger.Module;

@Module
interface ModuleBindings {

  @Binds
  Counter counter(CounterImpl counter);
}
