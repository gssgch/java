package com.baodian.test;

//Error 和Exception类等的子类
public class ExceptionAndError {

    public static void main(String[] args) {

        //常见的RuntimeException
        /**
        ArithmeticException 
        ClassCaseException 
        NullPointerException 
        ArrayIndexOutOfBoundsException
        (IndexOutOfBoundsException的子类)
        IllegalArgumentException
        EmptyStackException
        ArrayStoreException
        SystemException
        DOMException
        BufferOverflowException
        MissingResourceException
        */
        //常见的Exception
        /**
        ClassNotFoundException  
        SQLException 
        IOException 
        RuntimeException
        NoSuchMethodException
        ApplicationException
        DataFormatException
        NoSuchFieldException
        ParseException
        PrinterException
        */
    }

    //java.lang.Error类的直接已知子类
    public void error() {
        /*
        AnnotationFormatError, AssertionError, AWTError, 
        CoderMalfunctionError, FactoryConfigurationError,
        LinkageError, ThreadDeath,VirtualMachineError
        TransformerFactoryConfigurationError
        */
    }

    //java.lang.Exception类的直接已知子类
    public void Exception() {
        /*
        AclNotFoundException, ActivationException, 
        AlreadyBoundException, ApplicationException, 
        AWTException, BackingStoreException, 
        BadAttributeValueExpException, 
        BadBinaryOpValueExpException, BadLocationException, 
        BadStringOperationException, BrokenBarrierException,
        CertificateException, ClassNotFoundException, 
        CloneNotSupportedException, DataFormatException,
        DatatypeConfigurationException, DestroyFailedException,
        ExecutionException, ExpandVetoException, FontFormatException, 
        GeneralSecurityException, GSSException, IllegalAccessException,
        IllegalClassFormatException, InstantiationException, InterruptedException,
        IntrospectionException, InvalidApplicationException, InvalidMidiDataException,
        InvalidPreferencesFormatException, InvalidTargetObjectTypeException, 
        InvocationTargetException, IOException, JMException, LastOwnerException, 
        LineUnavailableException, MidiUnavailableException, MimeTypeParseException,
        NamingException, NoninvertibleTransformException, NoSuchFieldException,
        NoSuchMethodException, NotBoundException, NotOwnerException, ParseException,
        ParserConfigurationException, PrinterException, PrintException, 
        PrivilegedActionException, PropertyVetoException, RefreshFailedException,
        RemarshalException, RuntimeException, SAXException, ServerNotActiveException,
        SQLException, TimeoutException, TooManyListenersException, TransformerException,
        UnmodifiableClassException, UnsupportedAudioFileException, 
        UnsupportedCallbackException, UnsupportedFlavorException, 
        UnsupportedLookAndFeelException, URISyntaxException,
        UserException, XAException, XMLParseException, XPathException
        */
    }

    //java.lang.RuntimeException 类的直接子类
    public void RuntimeException() {
        //ArrayIndexOutOfBoundsException//继承了IndexOutOfBoundsException
        /*
        AnnotationTypeMismatchException, ArithmeticException, ArrayStoreException,
        BufferOverflowException, BufferUnderflowException, CannotRedoException,
        CannotUndoException, ClassCastException, CMMException,
        ConcurrentModificationException, DOMException, EmptyStackException,
        EnumConstantNotPresentException, EventException, IllegalArgumentException,
        IllegalMonitorStateException, IllegalPathStateException, 
        IllegalStateException, ImagingOpException, IncompleteAnnotationException,
        IndexOutOfBoundsException, JMRuntimeException, LSException,
        MalformedParameterizedTypeException, MissingResourceException, 
        NegativeArraySizeException, NoSuchElementException, NullPointerException, 
        ProfileDataException, ProviderException, RasterFormatException,
        RejectedExecutionException, SecurityException, SystemException, 
        TypeNotPresentException, UndeclaredThrowableException, 
        UnmodifiableSetException, UnsupportedOperationException 
        */
    }

    //java.io.IOException的直接子类
    public void IOException() {
        /*
        ChangedCharSetException, CharacterCodingException, 
        CharConversionException, ClosedChannelException, EOFException, 
        FileLockInterruptionException, FileNotFoundException, 
        HttpRetryException, IIOException, InterruptedIOException, 
        InvalidPropertiesFormatException, JMXProviderException, 
        JMXServerErrorException, MalformedURLException, ObjectStreamException, 
        ProtocolException, RemoteException, SaslException, SocketException, 
        SSLException, SyncFailedException, UnknownHostException, 
        UnknownServiceException, UnsupportedEncodingException, 
        UTFDataFormatException, ZipException 
        */
    }

    //java.sql.SQLException 类的直接子类
    public void SQLException() {
        /*
        BatchUpdateException, RowSetWarning, SerialException, 
        SQLWarning, SyncFactoryException, SyncProviderException 
        */
    }
}
