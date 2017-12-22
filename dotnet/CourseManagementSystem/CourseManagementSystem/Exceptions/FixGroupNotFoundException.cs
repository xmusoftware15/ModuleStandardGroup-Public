using System;
using System.Runtime.Serialization;

namespace Xmu.Crms.Shared.Exceptions
{
    [Serializable]
    public class FixGroupNotFoundException : ArgumentOutOfRangeException
    {
        public FixGroupNotFoundException()
        {
        }

        public FixGroupNotFoundException(string paramName) : base(paramName)
        {
        }

        public FixGroupNotFoundException(string message, Exception innerException) : base(message, innerException)
        {
        }

        public FixGroupNotFoundException(string paramName, string message) : base(paramName, message)
        {
        }

        public FixGroupNotFoundException(string paramName, object actualValue, string message) : base(paramName, actualValue, message)
        {
        }

        protected FixGroupNotFoundException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}