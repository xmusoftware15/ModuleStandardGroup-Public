using System;
using System.Runtime.Serialization;

namespace Xmu.Crms.Shared.Exceptions
{
    [Serializable]
    public class GroupNotFoundException : ArgumentOutOfRangeException
    {
        public GroupNotFoundException()
        {
        }

        public GroupNotFoundException(string paramName) : base(paramName)
        {
        }

        public GroupNotFoundException(string message, Exception innerException) : base(message, innerException)
        {
        }

        public GroupNotFoundException(string paramName, string message) : base(paramName, message)
        {
        }

        public GroupNotFoundException(string paramName, object actualValue, string message) : base(paramName, actualValue, message)
        {
        }

        protected GroupNotFoundException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}