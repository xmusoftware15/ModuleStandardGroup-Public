using System;
using System.Runtime.Serialization;

namespace Xmu.Crms.Shared.Exceptions
{
    [Serializable]
    public class PhoneAlreadyExistsException : ArgumentException
    {
        public PhoneAlreadyExistsException()
        {
        }

        public PhoneAlreadyExistsException(string message) : base(message)
        {
        }

        public PhoneAlreadyExistsException(string message, Exception innerException) : base(message, innerException)
        {
        }

        public PhoneAlreadyExistsException(string message, string paramName) : base(message, paramName)
        {
        }

        public PhoneAlreadyExistsException(string message, string paramName, Exception innerException) : base(message, paramName, innerException)
        {
        }

        protected PhoneAlreadyExistsException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}