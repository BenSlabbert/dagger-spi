/* Licensed under Apache-2.0 2025. */
package github.benslabbert.dagger.spi;

import dagger.model.BindingGraph;
import dagger.model.Key;
import dagger.spi.BindingGraphPlugin;
import dagger.spi.DiagnosticReporter;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Filer;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sourced from: <a
 * href="https://blog.joetr.com/dagger-spi-adding-custom-graph-validation-with-ksp-and-tests">this
 * blog</a>
 */
public class SPI implements BindingGraphPlugin {

  private static final Logger log = LoggerFactory.getLogger(SPI.class);

  private static final Set<String> QUALIFIED_CLASS_NAMES =
      Set.of(
          String.class.getCanonicalName(),
          byte.class.getCanonicalName(),
          Byte.class.getCanonicalName(),
          char.class.getCanonicalName(),
          Character.class.getCanonicalName(),
          short.class.getCanonicalName(),
          Short.class.getCanonicalName(),
          int.class.getCanonicalName(),
          Integer.class.getCanonicalName(),
          long.class.getCanonicalName(),
          Long.class.getCanonicalName(),
          float.class.getCanonicalName(),
          Float.class.getCanonicalName(),
          double.class.getCanonicalName(),
          Double.class.getCanonicalName(),
          boolean.class.getCanonicalName(),
          Boolean.class.getCanonicalName());

  public SPI() {
    log.info("init SPI");
  }

  @Override
  public void visitGraph(BindingGraph bindingGraph, DiagnosticReporter diagnosticReporter) {
    log.info("visitGraph");
    bindingGraph.bindings().stream()
        .filter(
            binding -> {
              Key key = binding.key();
              boolean qualifierPresent = key.qualifier().isPresent();
              String keyType = key.type().toString();
              return QUALIFIED_CLASS_NAMES.contains(keyType) && !qualifierPresent;
            })
        .forEach(
            binding ->
                diagnosticReporter.reportBinding(
                    Diagnostic.Kind.ERROR,
                    binding,
                    "Primitives should have a qualifier (@jakarta.inject.Named)"));
  }

  @Override
  public void initFiler(Filer filer) {
    log.info("initFiler");
  }

  @Override
  public void initTypes(Types types) {
    log.info("initTypes");
  }

  @Override
  public void initElements(Elements elements) {
    log.info("initElements");
  }

  @Override
  public void initOptions(Map<String, String> options) {
    log.info("initOptions");
  }

  @Override
  public Set<String> supportedOptions() {
    log.info("supportedOptions");
    return Set.of();
  }

  @Override
  public String pluginName() {
    log.info("pluginName");
    return getClass().getCanonicalName();
  }

  @Override
  public void onPluginEnd() {
    log.info("onPluginEnd");
  }
}
