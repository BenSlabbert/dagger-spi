/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi.example.repo;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
class RepoImpl implements Repo {

  @Inject
  RepoImpl() {}

  @Override
  public String getData() {
    return "data";
  }
}
