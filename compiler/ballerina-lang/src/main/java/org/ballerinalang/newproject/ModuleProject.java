/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.newproject;

import org.ballerinalang.toml.model.LockFile;
import org.ballerinalang.toml.model.Manifest;
import org.wso2.ballerinalang.compiler.util.CompilerOptions;

import java.nio.file.Path;

import static org.wso2.ballerinalang.compiler.util.ProjectDirConstants.SOURCE_DIR_NAME;

public class ModuleProject implements Project {

    Path sourcePath;
    Manifest manifest;
    LockFile lockFile;

    public ModuleProject(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    @Override
    public boolean isModuleExists(ModuleId moduleId) {
        String projectOrgName = this.manifest.getProject().getOrgName();
        if (projectOrgName.equals(moduleId.getOrgName())) {
            Path modulePath = this.sourcePath.resolve(SOURCE_DIR_NAME).resolve(moduleId.getModuleName());
            return modulePath.toFile().exists();
        }
        return false;
    }

    @Override
    public Module getModule(ModuleId moduleId) {
        return null;
    }

    @Override
    public Toml getToml() {
        return null;
    }

    @Override
    public boolean hasLockFile() {
        return this.lockFile != null;
    }

    @Override
    public LockFile getLockFile() {
        return this.lockFile;
    }

    @Override
    public JarResolver getJarResolver() {
        return null;
    }

    @Override
    public void setOptions(CompilerOptions options) {

    }
}
