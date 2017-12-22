using System;
using System.Runtime.Serialization;

namespace Xmu.Crms.Shared.Exceptions
{
    [Serializable]
    public class TopicNotFoundException : ArgumentOutOfRangeException
    {
        public TopicNotFoundException()
        {
        }

        public TopicNotFoundException(string paramName) : base(paramName)
        {
        }

        public TopicNotFoundException(string message, Exception innerException) : base(message, innerException)
        {
        }

        public TopicNotFoundException(string paramName, string message) : base(paramName, message)
        {
        }

        public TopicNotFoundException(string paramName, object actualValue, string message) : base(paramName, actualValue, message)
        {
        }

        protected TopicNotFoundException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}