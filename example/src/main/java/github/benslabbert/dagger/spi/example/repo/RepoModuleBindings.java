/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.repo;

import dagger.Binds;
import dagger.Module;

@Module
interface RepoModuleBindings {

  @Binds
  Repo repo(RepoImpl repo);
}
