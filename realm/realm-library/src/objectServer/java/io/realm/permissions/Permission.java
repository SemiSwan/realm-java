/*
 * Copyright 2017 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.permissions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;


/**
 * TODO: Public description of what a a Permission is and how it works
 */
public class Permission extends RealmObject {

    /**
     * TODO: Public description of what a permission is and how it works
     */
    public enum AccessLevel {
        /**
         * TODO: add description
         */
        NONE(false, false, false),

        /**
         * TODO: add description
         */
        READ(true, false, false),

        /**
         * TODO: add description
         */
        WRITE(true, true, false),

        /**
         * TODO: add description
         */
        ADMIN(true, true, true);

        private final boolean mayRead;
        private final boolean mayWrite;
        private final boolean mayManage;

        AccessLevel(boolean mayRead, boolean mayWrite, boolean mayManage) {
            this.mayRead = mayRead;
            this.mayWrite = mayWrite;
            this.mayManage = mayManage;
        }

        public boolean mayRead() {
            return mayRead;
        }

        public boolean mayWrite() {
            return mayWrite;
        }

        public boolean mayManage() {
            return mayManage;
        }
    }

        @PrimaryKey
    @Required
    private String id = UUID.randomUUID().toString();
    @Required
    private Date createdAt = new Date();
    @Required
    private Date updatedAt = new Date();
    private String userId;
    private String realmUrl;
    private boolean mayRead;
    private boolean mayWrite;
    private boolean mayManage;

    public Permission() {
    }



    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public boolean canRead() {
        return mayRead;
    }

    public boolean canWrite() {
        return mayWrite;
    }

    public boolean isMayManage() {
        return mayManage;
    }

    public URL getRealmUrl() {
        try {
            return new URL(realmUrl);
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }
}