package com.smashplus.cityxplor.service.qanda;/*
 * Copyright 2010 Nabeel Mukhtar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */


import org.springframework.stereotype.Service;

import java.util.List;


/**
 * The Class QuestionsApiExample.
 */
@Service
public class StackExchangeService {

    /** The Constant APPLICATION_KEY_OPTION. */
    private static final String APPLICATION_KEY_OPTION = "khF9QKReYWUkOZ51fkJriw((";

    /** The Constant STACK_EXCHANGE_SITE. */
    private static final String STACK_EXCHANGE_SITE = "stackoverflow";

    /** The Constant ID_OPTION. */
    private static final String ID_OPTION = "53747595";

    /** The Constant HELP_OPTION. */
    private static final String HELP_OPTION = "cxvxc";

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        //Options options = buildOptions();
        try {
            //CommandLine line = new BasicParser().parse(options, args);
            //processCommandLine(null, null);
        } catch (Exception exp) {
            System.err.println(exp.getMessage());
        }
    }

    /**
     * Process command line.
     *  @param qtnId
     *            the line
     * @return
     */
    public  List<Question> getQuestion(String qtnId) {
       /* if (line.hasOption(HELP_OPTION)) {
            printHelp(options);
        } else*/

            final String keyValue = APPLICATION_KEY_OPTION;
            final String siteValue = STACK_EXCHANGE_SITE;





            final StackExchangeApiClientFactory factory = StackExchangeApiClientFactory
                    .newInstance(keyValue,
                            StackExchangeSite.fromValue(siteValue));
            final StackExchangeApiClient client = factory
                    .createStackExchangeApiClient();



                String idValue = qtnId;
                List<Question> question = client.getQuestions(Long
                        .valueOf(idValue));
                printResult(question.get(0));
                return question;


    }

    /**
     * Process command line.
     *  @param tag
     *            the line
     * @return
     */
    public  Question getQuestionOnTags(String tag, int page) {
       /* if (line.hasOption(HELP_OPTION)) {
            printHelp(options);
        } else*/

        final String keyValue = APPLICATION_KEY_OPTION;
        final String siteValue = STACK_EXCHANGE_SITE;





        final StackExchangeApiClientFactory factory = StackExchangeApiClientFactory
                .newInstance(keyValue,
                        StackExchangeSite.fromValue(siteValue));
        final StackExchangeApiClient client = factory
                .createStackExchangeApiClient();



        Question question = client.getQuestionsOnTags(tag, page);
        printResult(question);
        return question;


    }


    /**
     * Prints the result.
     *
     * @param question
     *            the question
     */
    private static void printResult(Question question) {
        System.out.println(">>"+question.getTitle() + ":"
                + question.getAnswerCount());System.out.println(">>"+question.getBody() );
    }


}
