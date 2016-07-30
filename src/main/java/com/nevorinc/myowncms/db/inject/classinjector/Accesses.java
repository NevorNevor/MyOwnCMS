package com.nevorinc.myowncms.db.inject.classinjector;

public enum Accesses {
    PUBLIC {
        @Override
        public String toString() {
            return "public";
        }
    },
    PRIVATE {
        @Override
        public String toString() {
            return "private";
        }
    },
    PROTECTED {
        @Override
        public String toString() {
            return "protected";
        }
    },
    DEFAULT {
        @Override
        public String toString() {
            return "";
        }
    };

}
