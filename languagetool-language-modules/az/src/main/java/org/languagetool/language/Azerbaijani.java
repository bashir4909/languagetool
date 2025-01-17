/* LanguageTool, a natural language style checker
 * Copyright (C) 2014 Daniel Naber & Marcin Miłkowski (http://www.languagetool.org)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.language;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.languagetool.*;
import org.languagetool.rules.*;
import org.languagetool.rules.spelling.hunspell.HunspellRule;
import org.languagetool.synthesis.Synthesizer;
import org.languagetool.tagging.Tagger;
import org.languagetool.tagging.disambiguation.Disambiguator;
import org.languagetool.tokenizers.*;

import java.io.IOException;
import java.util.*;

public class Azerbaijani extends Language {

  @Override
  public String getName() {
    return "Azerbaijani";
  }

  @Override
  public String getShortCode() {
    return "az";
  }

  @Override
  public String[] getCountries() {
    return new String[]{"AZ"};
  }

  @Override
  public SentenceTokenizer createDefaultSentenceTokenizer() {
    return new SRXSentenceTokenizer(this);
  }

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[] { Contributors.MARCIN_MILKOWSKI };
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages, UserConfig userConfig, Language motherTongue, List<Language> altLanguages) throws IOException {
    return Arrays.asList(
      new CommaWhitespaceRule(messages),
      new UppercaseSentenceStartRule(messages, this),
      new HunspellRule(messages,this, userConfig),
      new WordRepeatRule(messages, this),
      new MultipleWhitespaceRule(messages, this),
      new SentenceWhitespaceRule(messages)
    );
  }

  @Override
  public LanguageMaintainedState getMaintainedState() {
    return LanguageMaintainedState.ActivelyMaintained;
  }

}
