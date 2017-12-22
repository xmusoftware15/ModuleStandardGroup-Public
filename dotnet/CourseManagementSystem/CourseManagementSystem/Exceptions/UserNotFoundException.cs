using System;
using System.Runtime.Serialization;

namespace Xmu.Crms.Shared.Exceptions
{
    [Serializable]
    public class UserNotFoundException : ArgumentOutOfRangeException
    {
        public UserNotFoundException()
        {
        }

        public UserNotFoundException(string paramName) : base(paramName)
        {
        }

        public UserNotFoundException(string message, Exception innerException) : base(message, innerException)
        {
        }

        public UserNotFoundException(string paramName, string message) : base(paramName, message)
        {
        }

        public UserNotFoundException(string paramName, object actualValue, string message) : base(paramName, actualValue, message)
        {
        }

        protected UserNotFoundException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}