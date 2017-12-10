# Dao(包)  
### UserDao（类）
1. UserDO getUserByUserId(BigInteger userId)
    * 方法简介:根据用户id返回用户信息
    * 参数:  
        - BigInteger userId(用户的id)
    * 返回值: UserDO 用户的信息
    * 调用的Mapper方法:
        - UserMapper.selectUserByUserId(BigInteger userId)

2. List<UserDO>  listPresentStudent(BigInteger seminarId,BigInteger classId)
    * 方法简介:根据seminar id和class id去查找所有的迟到学生的信息
    * 参数:  1.BigInteger seminarId（讨论课id）,2.BigInteger classId（班级id）
    * 返回值: List<UserDO>  所有学生的信息
    * 调用的Mapper方法:UserMapper.selectPresentStudent(BigInteger seminarId,BigInteger classId)

3. List<UserDO>  listAbsenceStudent(BigInteger seminarId,BigInteger classId)
    * 方法简介:根据seminar id和class id去查找所有的缺勤学生的信息
    * 参数:  1.BigInteger seminarId（讨论课id）,2.BigInteger classId（班级id）
    * 返回值: List<UserDO>  所有学生的信息
    * 调用的Mapper方法:UserMapper.selectAbsenceStudent(BigInteger seminarId,BigInteger classId)

4. List <UserDO> listLateStudent(BigInteger seminarId,BigInteger classId)
    * 方法简介:根据seminar id和class id去查找所有的迟到学生的信息
    * 参数:  1.BigInteger seminarId（讨论课id）,2.BigInteger classId（班级id）
    * 返回值: List<UserDO>  所有学生的信息
    * 调用的Mapper方法:UserMapper.selectLateStudent(BigInteger seminarId,BigInteger classId)
5. UserDO getUserByUserId(BigInteger UserId)  
    - 方法简述:根据User的id获得User信息  
    - 参数：数据库自动生成的User的Id  
    - 返回值：该UserId对应的User  
    - 调用的Mapper方法：UserMapper.selectUserById(BigInteger UserId)  

6. boolean updateUserById(BigInteger UserId,UserDO user)  
    - 方法简述：根据User的id修改User  
    - 参数：数据库自动生成的User的Id、前端传来的User(修改后的)  
    - 返回值：修改成功返回true，否则false  
    - 调用的Mapper方法：UserMapper.updateUserById(BigInteger UserId,UserDO user)  

7. UserDO signInWeChat(String code,String state,String success_url)  
    - 方法简述：微信登录  
    - 参数：用户Id、微信小程序/OAuth2授权的Code、微信OAuth2授权的state。对于小程序，值恒为 MiniProgram、微信OAuth2授权后跳转到的网址  
    - 返回值：该用户  
    - 调用的Mapper方法：UserMapper.signInWeChat(BigInteger UserId,String code,String state,String success_url)  

8. UserDO signInPhone(UserDO user)  
    - 方法简述：手机号登录  
    - 参数：用户（手机号和密码）  
    - 返回值：该用户  
    - 调用的Mapper方法：UserMapper.selectUserByUserPhone(String phoneNumber)  

9. UserDO signUpPhone(UserDO user)  
    - 方法简述：手机号注册  
    - 参数：用户（手机号和密码，无Id）  
    - 返回值：该用户  
    - 调用的Mapper方法：UserMapper.signUpPhone()  
    - 说明：参数User中只有Phone和Password  

10. List<UserDO> listUserBeginWithNumAndName(BigInteger classId,String numBeginWith,String nameBeginWith) 
    - 方法简述：按班级id、学号开头、姓名开头获取学生列表
    - 参数：班级id、学号开头、姓名开头
    - 返回值：学生列表
    - 调用的Mapper方法：
        - UserMapper.selectUserBeginWithNumAndName(BigInteger classId,String numBeginWith,String nameBeginWith)

11. List<UserDO> listUserBeginWithNum(BigInteger classId,String numBeginWith) 
    - 方法简述：按班级id、学号开头获取学生列表
    - 参数：班级id、学号开头
    - 返回值：学生列表
    - 调用的Mapper方法： 
         - UserMapper.selectUserBeginWithNumAndName(BigInteger classId,String numBeginWith,String nameBeginWith)

12. List<UserDO> listUserBeginWithName(BigInteger classId,String nameBeginWith) 
    - 方法简述：按班级id、姓名开头获取学生列表
    - 参数：班级id、姓名开头
    - 返回值：学生列表
    - 调用的Mapper方法：        
        - UserMapper.selectUserBeginWithName(BigInteger classId,String nameBeginWith)
### SeminarDao（类）
1. SeminarDO getSeminarBySeminarId(BigInteger seminarId)  
    * 方法简述：按讨论课讨论课id获取讨论课  
    * 参数：BigInteger seminarId 讨论课id  
    * 返回值：SeminarDO 讨论课信息  
    * 调用的Mapper方法： SeminarMapper. selectSeminarBySeminarId(BigInteger seminarId) 
 
2. boolean  updateSeminarBySeminarId(SeminarDO seminar)  
    * 方法简述：按讨论课id修改讨论课  
    * 参数：SeminarDO seminar 讨论课信息  
    * 返回值：true/false 是否修改成功  
    * 调用的Mapper方法：SeminarMapper. updateSeminarBySeminarId(SeminarDO seminar) 
 
3. boolean deleteSeminarBySeminarId(SeminarDO seminar)  
    * 方法简述：按讨论课id删除讨论课  
    * 参数：SeminarDO seminar 讨论课信息  
    * 返回值：true/false是否删除成功  
    * 调用的Mapper方法：SeminarMapper. deleteSeminarBySeminarId(SeminarDO seminar)

### ClassDao（类）
1. List<ClassDO> listClassByCourseName(String courseName)
    - 方法简述：按课程名称获取班级列表
    - 参数：课程名称
    - 返回值：班级列表
    - 调用的Mapper方法：ClassMapper.selectClassByCourseName(String courseName) 

2. List<ClassDO> listClassByTeacherName(String teacherName)
    - 方法简述：按老师名称获取班级列表
    - 参数：老师名称
    - 返回值：班级列表
    - 调用的Mapper方法：ClassMapper.selectClassByTeacherName(String teacherName) 

3. ClassDO getClassByClassId(BigInteger classId) 
    - 方法简述：按班级id获取班级详情
    - 参数：班级id
    - 返回值：班级
    - 调用的Mapper方法：ClassMapper.selectClassByClassId(BigInteger classId)

4. boolean updateClassByClassId(BigInteger classId,ClassDO class) 
    - 方法简述：按班级id和班级修改班级信息
    - 参数：班级id、班级
    - 返回值：是否修改成功
    - 调用的Mapper方法：ClassMapper.updateClassByClassId(BigInteger classId,ClassDO class) 

5. boolean deleteClassByClassId(BigInteger classId)
    - 方法简述：按班级id删除班级
    - 参数：班级id
    - 返回值：是否删除成功
    - 调用的Mapper方法：ClassMapper.deleteClassByClassId(BigInteger classId)

6. (url无法确定返回类型） insertStudentClassById(User user,BigInteger classId) 
    - 方法简述：学生按班级id选择班级
    - 参数：学生、班级id
    - 返回值：(url无法确定返回类型）
    - 调用的Mapper方法：ClassMapper.insertStudentClassById(User user,BigInteger classId) 

7. boolean deleteStudentClassById(BigInteger classId,BigInteger studentId)
    - 方法简述：学生按班级id和学生id取消班级选择
    - 参数：班级id、学生id
    - 返回值：取消班级是否成功
    - 调用的Dao方法：ClassMapper.deleteStudentClassById(BigInteger classId,BigInteger studentId)

8. ClassDO getClassByClassId(BigInteger classId)
    * 方法简介:根据班级的id来获得班级信息
    * 参数:  1.BigInteger classId (班级的id)
    * 返回值: ClassDO 班级的信息
    * 调用的Mapper方法:ClassMapper.selectClassByClassId(BigInteger classId)

9. ClassDO getClassById(BigInteger seminarId,BigInteger userId)
    * 方法简介:根据用户id和讨论课的id来获得当前用户所上讨论课的所在班级信息
    * 参数:  1.BigInteger seminarId (讨论课的id) 2.BigInteger userId(用户的id)
    * 返回值: ClassDO 班级的信息
    * 调用的Mapper方法:ClassMapper.selectClassById(BigInteger seminarId,BigInteger userId)

### CourseDao（类）
1. List<CourseDO> listCourseByUserId(BigInteger userId)  
    * 方法描述：按userId获取与当前用户相关联的课程列表  
    * 参数：userId  
    * 返回值：课程列表  
    * 调用的Mapper方法：List<CourseDO> selectCourseByUserId(BigInteger userId)  

2. CourseDO insertCourseByUserId(BigInteger userId,Course course)  
    * 方法描述：按userId创建课程  
    * 参数：userId，course对象  
    * 返回值：course对象  
    * 调用的Mapper方法：CourseDO insertCourseByUserId(BigInteger userId,CourseDO course)  

3. CourseDO getCourseByCourseId(BigInteger courseId)  
    * 方法描述：按courseId获取课程  
    * 参数：courseId  
    * 返回值：course对象  
    * 调用的Mapper方法：Course selectCourseByCourseId(BigInteger courseId)  

4. boolean updateCourseByCourseId(BigInteger courseId,CourseDO course)  
    * 方法描述：按courseId修改课程  
    * 参数：courseId，course对象  
    * 返回类型：boolean（用于判断是否修改成功）
    * 调用的Mapper方法：boolean updateCourseByCourseId(BigInteger courseId,CourseDO course)  

5. boolean deleteCourseByCourseId(BigInteger courseId)  
    * 方法描述：按courseId删除课程  
    * 参数：courseId  
    * 返回值：boolean（用于判断是否删除成功）
    * 调用的Mapper方法：boolean deleteCourseByCourseId(BigInteger courseId)  
### TopicDao（类）
1. TopicDO getTopicByTopicId(BigInteger topicId)
    * 方法简介:根据话题Id获得改话题的信息
    * 参数:  1.BigInteger topicId (话题的id)
    * 返回值: TopicDO  该话题的信息
    * 调用的Mapper方法:TopicMapper.selectTopicByTopicId(BigInteger topicId)

2. boolean updateTopicByTopicId(BigInteger topicId，TopicDO topic)
    * 方法简介:根据话题的id和topic 的信息修改对应的topic 的内容
    * 参数:  1.BigInteger topicId（话题的id） 2.TopicDO topic（要修改的话题的内容）
    * 返回值:  是否成功修改话题
    * 调用的Mapper方法:TopicMapper.updateTopicByTopicId(BigInteger topicId，TopicDO topic)

3. boolean deleteTopicByTopicId(BigInteger topicId)
    * 方法简介:根据话题的Id删除该话题
    * 参数:  1.BigInteger topicId (话题的id)
    * 返回值: 是否成功删除话题
    * 调用的Mapper方法:TopicMapper.deleteTopicByTopicId(BigInteger topicId)

4. List<TopicDO>  listTopicBySeminarId(BigInteger seminarId)
    * 方法简介:根据讨论课的id来获得当前讨论课的所有话题信息
    * 参数:  1.BigInteger seminarId (讨论课的id)
    * 返回值: .List<TopicDO>  所有讨论课的信息
    * 调用的Mapper方法:TopicMapper.selectTopicBySeminarId(BigInteger seminarId)

5. BigInteger insertTopicBySeminarId(BigInteger seminarId,TopicDO topic)  
    * 方法简介:根据讨论课的id来获得当前讨论课的所有话题信息
    * 参数:  1.BigInteger seminarId (讨论课的id)  2.TopicDO topic(要创建的话题信息)
    * 返回值: 话题的id
    * 调用的Mapper方法:TopicMapper.insertTopicBySeminarId(BigInteger seminarId,TopicDO topic)

### GroupDao（类）

1. GroupDO getGroupById(BigInteger seminarId，BigInteger userId)
    * 方法简介:获得与当前学生在当前讨论课的小组信息（队长是谁，是否选题等）
    * 参数:  1.BigInteger seminarId (讨论课的id) 2.BigInteger userId（学生的id）
    * 返回值: GroupDO 小组的信息
    * 调用的Mapper方法:Groupper.selectGroupById(BigInteger seminarId，BigInteger userId)

2. List<GroupDO> listGroupByTopicId(BigInteger topicId)
    * 方法简介:根据话题Id获得选择该话题的所有小组的信息
    * 参数:  1.BigInteger topicId(话题的id)
    * 返回值: List<GroupDO> 所有选择该话题的所有group的信息
    * 调用的Mapper方法:GroupMapper. selectGroupByTopicId(BigInteger topicId)

3. List<GroupDO> listGroupBySeminarId(BigInteger seminarId)
    * 方法简介:获得与当前讨论课的所有小组信息
    * 参数:  1.BigInteger seminarId (讨论课的id)
    * 返回值: List<GroupDO> 所有小组的信息
    * 调用的Mapper方法:GroupMapper.selectGroupBySeminarId(BigInteger seminarId)

4.  String insertTopicByGroupId(BigInteger groupId, BigInteger topicId)   
    * 方法简述：小组按ID选择话题  
    * 参数：groupId、topicId
    * 返回值：url
    * 调用的Mapper方法：topicMapper.insertTopicByGroupId(BigInteger groupId, BigInteger topicId)  

5. boolean deleteTopicByGroupId(BigInteger groupId)  
    * 方法简述：小组取消选择话题  
    * 参数：groupId  
    * 返回值：true/false
    * 调用的Mapper方法：topicMapper.deleteTopicByGroupId(BigInteger groupId)
6. String insertTopicByGroupId(BigInteger groupId, BigInteger topicId)  
    * 方法简述：小组按ID选择话题  
    * 参数：groupId、topicId  
    * 返回值：(url取法确定类型)  
    * 调用的Mapper方法：topicMapper.insertTopicByGroupId(BigInteger groupId, BigInteger topicId)  

7. boolean deleteTopicByGroupId(BigInteger groupId)  
    * 方法简述：小组取消选择话题  
    * 参数：groupId  
    * 返回值：true/false  
    * 调用的Mapper方法：topicMapper.deleteTopicByGroupId(BigInteger groupId)   
8. GroupDO getFixedGroupById(BigInteger userId,BigInteger classId)
    - 方法简述：按学生id和班级id获取学生所在小组
    - 参数：学生id、班级id
    - 返回值：小组
    - 调用的Mapper方法：GroupMapper.selectFixedGroupById(BigInteger userId,BigInteger classId)  

### GradeDAO（类）
1. BigInteger countGradeByGroupId(BigInteger groupId)  
    * 方法简述：计算小组得分  
    * 参数：groupId
    * 返回值：grade
    * 调用的Mapper方法：gradeMapper.countGradeByGroupId(BigInteger groupId)  

2.  BigInteger countPresentationGrade(BigInteger groupId, BigInteger seminarId)  
    * 方法简述：计算展示得分
    * 参数：groupId、seminarId
    * 返回值：grade
    * 调用的Mapper方法：gradeMapper.countPresentationGrade(BigInteger groupId, BigInteger seminarId)  

3.  boolean updateGroupByGroupId(BigInteger groupId, BigInteger grade)(保留)  
    * 方法简述：设置小组报告分  
    * 参数：grade、groupId
    * 返回值：true/false
    * 调用的Mapper方法：gradeMapper.updateGroupByGroupId(BigInteger groupId, BigInteger grade  

4. boolean insertGroupGradeByUserId(BigInteger groupId, BigInteger userId)  
    * 方法简述：提交对其他小组的打分
    * 参数：userId、groupId
    * 返回值：true/false
    * 调用的Mapper方法：  
        - gradeMapper.insertGroupGradeByUserId(BigInteger groupId, BigInteger userId)

### AttendanceDao（类）
1. Boolean updateAttendanceById(integer seminarId,integer classId,integer userId,String status)
    * 方法简介:根据讨论课id， 班级id，学生id，在考勤表修改学生的考勤状态为出勤
    * 参数:  1.BigInteger seminarId (讨论课的id) 2.BigInteger classId（班级的id） 3.BigInteger userId（学生的id）4.String status
    * 返回值: 是否成功修改考勤状态
    * 调用的Mapper方法:AttendanceMapper.updateAttendanceById(integer seminarId,integer classId,integer userId,String status)

### SchoolDao（类）：  
1. List<SchoolDO> listSchoolByCity(string city)  
    * 方法描述：按照城市名称查找学校  
    * 参数：string city  
    * 返回值：学校列表  
    * 调用的Mapper方法：List<SchoolDO> selectSchoolByCity(string city)  

2. BigInteger insertSchool(SchoolDO school)  
    * 方法描述：添加学校  
    * 参数：school对象  
    * 返回值：schoolId  
    * 调用的Mapper方法：BigInteger insertSchool(SchoolDO school)  

3. List<ProvinceDO> listProvince()  
    * 方法描述：获取省份列表  
    * 参数：无  
    * 返回值：省份列表  
    * 调用的Mapper方法：List<ProvinceDO> listProvince()  

4. List<CityDO> listCity(string province)  
    * 方法描述：获取城市列表  
    * 参数：string province  
    * 返回值：城市列表  
    * 调用的Mapper方法：List<CityDO> listCity(string province)  
5. SchoolDO getSchoolById(BigInteger SchoolId)  
    - 方法简述:根据School的id获得School信息  
    - 参数：数据库自动生成的School的Id  
    - 返回值：该SchoolId对应的School  
    - 调用的Mapper方法：SchoolMapper.selectShoolById(BigInteger SchoolId)  