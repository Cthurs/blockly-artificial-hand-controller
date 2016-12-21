/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.google.blockly.android.codegen;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.blockly.android.MyGlobals;

/**
 * Simple generator callback that logs the generated code to device Log and a Toast.
 */
public class LoggingCodeGeneratorCallback implements CodeGenerationRequest.CodeGeneratorCallback {
    protected final String mTag;
    protected final Context mContext;
    public LoggingCodeGeneratorCallback(Context context, String loggingTag) {
        mTag = loggingTag;
        mContext = context;
    }

    @Override
    public void onFinishCodeGeneration(String generatedCode) {
        // Sample callback.
        if (generatedCode.isEmpty()) {
            Toast.makeText(mContext,
                    "Something went wrong with code generation.", Toast.LENGTH_LONG).show();
        } else {
            if(generatedCode.contains("#")){
                MyGlobals.getInstance().setData(generatedCode);
                Toast.makeText(mContext, "저장 되었습니다.", Toast.LENGTH_LONG).show();
            }
            else if(!generatedCode.contains("#")){
                Toast.makeText(mContext, "동작 명을 정의 해주세요.", Toast.LENGTH_LONG).show();
            }
            //ToDO : 동작을 즉시 할 것인지 정하여 코드 입력
//            Toast.makeText(mContext, "동작 명을 정의 해주세요.", Toast.LENGTH_LONG).show();

        }

    }

}
