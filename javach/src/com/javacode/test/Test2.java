package com.javacode.test;

/*
 * 面试题，输出是
 */
public class Test2 {
    @SuppressWarnings("serial")
    class EA extends Exception {
        public EA() {
            super("EA");
        }
    }

    class EB extends Exception {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public EB() {
            super("EB");
        }
    }

    public void test4(boolean A) {
        try {
            try {
                if (A) {
                    throw new EA();
                } else {
                    throw new EB();
                }
            } catch (EB b1) {

                System.out.println(b1.getMessage());
                throw b1;
            } catch (EA a1) {

                System.out.println(a1.getMessage());
                throw new EB();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] a) {
        try {
            Test2 t = new Test2();
            t.test4(true);
            t.test4(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
