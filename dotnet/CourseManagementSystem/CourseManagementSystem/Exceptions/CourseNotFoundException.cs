using System;
using System.Runtime.Serialization;

namespace Xmu.Crms.Shared.Exceptions
{
    [Serializable]
    public class CourseNotFoundException : ArgumentOutOfRangeException
    {
        public CourseNotFoundException()
        {
        }

        public CourseNotFoundException(string paramName) : base(paramName)
        {
        }

        public CourseNotFoundException(string message, Exception innerException) : base(message, innerException)
        {
        }

        public CourseNotFoundException(string paramName, string message) : base(paramName, message)
        {
        }

        public CourseNotFoundException(string paramName, object actualValue, string message) : base(paramName, actualValue, message)
        {
        }

        protected CourseNotFoundException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}