# Service（包）  
### UserService（类）
1. List<UserBO> listPresentStudent(BigInteger seminarId,BigInteger classId)  
    * 方法简介:根据讨论课id及班级id，讨论课所在的班级出勤学生信息  
    *  参数:  
        - BigInteger seminarId (讨论课的id)  
        - BigInteger classId（班级的id）
    * 返回值: List<UserBO>   处于出勤状态的所有学生信息
    * 调用的dao方法:
        - UserDao.listPresentStudent(BigInteger seminarId,BigInteger classId)  
2. List<UserBO>  listLateStudent(BigInteger seminarId,BigInteger classId)  
    * 方法简介:根据讨论课id及班级id，讨论课所在的班级迟到学生信息  
    * 参数:  
        - BigInteger seminarId (讨论课的id)   
        - BigInteger classId（班级的id）
    * 返回值: List<UserBO>   处于迟到状态的所有学生信息  
    * 调用的dao方法:  
        - UserDao.listLateStudent(BigInteger seminarId,BigInteger classId)  
3. List<UserBO>  listAbsenceStudent(BigInteger seminarId,BigInteger classId)  
    * 方法简介:根据讨论课id及班级id，讨论课所在的班级的缺勤学生信息
    * 参数:  
        - BigInteger seminarId (讨论课的id)  
        - BigInteger classId（班级的id）
    * 返回值: List<UserBO>   处于缺勤状态的所有学生信息
    * 调用的dao方法:
        - UserDao.listAbsenceStudent(BigInteger seminarId,BigInteger classId)  
4. UserBO getUserByUserId(BigInteger UserId)  
    * 方法简述:根据User的id获得User信息  
    * 参数：
        - BigInteger UserId(数据库自动生成的User的Id ) 
    * 返回值：该UserId对应的User  
    * 调用的DAO方法：
        - MeDao.getUserByUserId(BigInteger UserId)  
        - SchoolDao.getSchoolBySchoolId(BigInteger SchoolId)  

5. boolean updateUserByUserId(BigInteger UserId,UserBO user)  
    * 方法简述：根据User的id修改User  
    * 参数：
        - BigInteger UserId (数据库自动生成的User的Id)
        - UserBO user 前端传来的User(修改后的)  
    * 返回值：修改成功返回true，否则false  
    * 调用的DAO方法：
        - UserDao.updateUserById(BigInteger UserId,UserDO user)  
6. User signInWeChat(BigInteger UserId,String code,String state,String success_url)  
    - 方法简述：微信登录  
    - 参数：
        - 用户Id
        - 微信小程序/OAuth2授权的Code
        - 微信OAuth2授权的state。对于小程序，值恒为 MiniProgram
        - 微信OAuth2授权后跳转到的网址  
    - 返回值：该用户  
    - 调用的DAO方法：
        - UserDao.signInWeChat(BigInteger UserId,String code,String state,String success_url)  

7. UserBO signInPhone(UserBO user)  
    - 方法简述：手机号登录  （.Net使用）
    - 参数：
        - 用户（手机号和密码）  
    - 返回值：该用户  
    - 调用的DAO方法：
        - UserDao.signInPhone(UserDO user)  
    - 说明：User中只有Phone和Password，用于判断用户名密码是否正确  

8. UserBO signUpPhone(UserBO user)  
    - 方法简述：手机号注册  （.Net使用）
    - 参数：
        - 用户（手机号和密码，无Id）  
    - 返回值：该用户  
    - 调用的DAO方法：
        - UserDao.signUpPhone(UserDO user)  
    - 说明：User中只有Phone和Password  

9. List<UserBO> listUserByClassId(BigInteger classId,String numBeginWith,String nameBeginWith)
    - 方法简述：按班级id、学号开头、姓名开头获取学生列表
    - 参数：
        - 班级id
        - 学号开头
        - 姓名开头
    - 返回值：学生列表
    - 调用的Dao方法：
        - UserDao.List<UserDO> listUserBeginWithNumAndName(BigInteger classId,String numBeginWith,String nameBeginWith)
        - UserDao.List<UserDO> listUserBeginWithNum(BigInteger classId,String numBeginWith)
        - UserDao.List<UserDO> listUserBeginWithName(BigInteger classId,String nameBeginWith)  

### SeminarService（类）
1. SeminarBO getMySeminarBySeminarId(BigInteger seminarId，User  userId)  
    * 方法简介:获得与当前学生相关的讨论课的信息（此学生是否是队长，当前讨论课是否处于签到状态，当前讨论课是否可以选题，当前讨论课的组队方式）
    * 参数:  
        - BigInteger seminarId (讨论课的id)  
        - User userId （用户的id）
    * 返回值: SeminarBo 讨论课的信息
    * 调用的dao方法:  
        - SeminarDao.getSeminarBySeminarId(BigInteger seminarId)  
        - GroupDao. getGroupById(BigInteger seminarId，BigInteger userId)  
2. SeminarBO getSeminarDetailBySeminarId(BigInteger seminarId,BigInteger userId)  
    * 方法简介:根据讨论课Id获得该讨论课的详细信息（包括讨论课信息，上课地点，教师信息）
    * 参数:  
        - BigInteger seminarId (讨论课的id)  
    * 返回值: SeminarBo 讨论课的详细信息  
    * 调用的dao方法:  
        - SeminarDao.getSeminarBySeminarId(BigInteger seminarId)  
        - UserDao.getUserByUserId(BigInteger userId)  
        - ClassDao.getClassById(BigInteger seminarId,BigInteger userId)  
3. SeminarBO getSeminarBySeminarId(BigInteger seminarId)  
    * 方法简述：按讨论课id获取讨论课  
    * 参数：  
        - BigInteger seminarId讨论课id  
    * 返回值：SeminarBO 讨论课信息  
    * 调用的Dao方法：  
        - SeminarDao.getSeminarBySeminarId(BigInteger seminarId)  
4. boolean  updateSeminarBySeminarId(SeminarBO seminar)  
    * 方法简述：按讨论课id修改讨论课  
    * 参数：  
        - SeminarBO seminar 讨论课信息  
    * 返回值：true/false 是否修改成功  
    * 调用的Dao方法:  
        - SeminarDao.updateSeminarBySeminarId(SeminarDO seminar)  
5. boolean deleteSeminarBySeminarId(SeminarBO seminar)  
    * 方法简述：按讨论课id删除讨论课  
    * 参数：  
        - SeminarBO seminar 讨论课信息  
    * 返回值：true/false是否删除成功  
    * 调用的Dao方法:  
        - SeminarDao.deleteSeminarBySeminarId(SeminarDO seminar)  
### TopicService（类）  
1. TopicBO getTopicByTopicId(BigInteger topicId)
    * 方法简介:根据话题Id获得改话题的信息
    * 参数:  
        - BigInteger topicId (话题的id)
    * 返回值: TopicBo  该话题的信息
    * 调用的dao方法:  
        - TopicDao.getTopicByTopicId(BigInteger topicId)  
2. boolean updateTopicByTopicId(BigInteger topicId，TopicBO topic)
    * 方法简介:根据话题的id和topic 的信息修改对应的topic 的内容
    * 参数:  
        - BigInteger topicId（话题的id）  
        - TopicBO topic（要修改的话题的内容）
    * 返回值:  是否成功修改话题
    * 调用的dao方法:
        - TopicDao.updateTopicByTopicId(BigInteger topicId，TopicDO topic)  
3. boolean deleteTopicByTopicId(BigInteger topicId)  
    * 方法简介:根据讨论课Id删除该话题
    * 参数:  1.BigInteger topicId (话题的id)
    * 返回值: 是否成功删除话题
    * 调用的dao方法:  
        - TopicDao.deleteTopicByTopicId(BigInteger topicId)  
4. List<TopicBO> listTopicBySeminarId(BigInteger seminarId)
    * 方法简介:根据讨论课Id获得该讨论课的所有topic的信息
    * 参数:  
        - BigInteger seminarId (讨论课的id)
    * 返回值: List<TopicBO>  该讨论课的所有topic的信息
    * 调用的dao方法:
        - TopicDao.listTopicBySeminarId(BigInteger seminarId)  
5. BigInteger insertTopicBySeminarId(BigInteger seminarId,TopicBO topic)
    * 方法简介:根据讨论课Id和topic的资料，创建一门属于该讨论课的话题
    * 参数:  
        - BigInteger seminarId (讨论课的id)   
        - TopicBO topic(话题的所有信息)
    * 返回值: 讨论课的id
    * 调用的dao方法:
        - TopicDao.insertTopicBySeminarId(BigInteger seminarId,TopicDO topic)  
6.  String insertTopicByGroupId(BigInteger groupId, BigInteger topicId)  
    * 方法简述：  小组按ID选择话题  
    * 参数： 
        - groupId
        - topicId  
    * 返回值：  url无法确定类型  
    * 调用的DAO方法：
        - topicDAO.insertTopicByGroupId(BigInteger groupId, BigInteger topicId)    

7. boolean deleteTopicByGroupId(BigInteger groupId)  
    * 方法简述：小组取消选择话题  
    * 参数：
        - groupId  
    * 返回值：true/false  
    * 调用的DAO方法：
        - topicDAO.deleteTopicByGroupId(BigInteger groupId)  
### GroupService（类）
1. List<GroupBO>  listGroupBySeminarId(BigInteger seminarId)
    * 方法简介:根据讨论课Id获得属于该讨论课的所有小组的信息
    * 参数:  
        - BigInteger seminarId (讨论课的id)
    * 返回值: List<GroupBO> 所有group的信息
    * 调用的dao方法:
        - GroupDao.listGroupBySeminarId(BigInteger seminarId)  
2. List<GroupBO> listGroupByTopicId(BigInteger topicId)
    * 方法简介:根据话题Id获得选择该话题的所有小组的信息
    * 参数:  
        - BigInteger topicId(话题的id)
    * 返回值: List<GroupBO> 所有选择该话题的所有group的信息
    * 调用的dao方法:
        - GroupDao. listGroupByTopicId(BigInteger topicId)  
3. GroupBO getSeminarGroupById(BigInteger seminarId,BigInteger userId)
    * 方法简介: 根据讨论课Id及用户id，获得该用户所在的讨论课的小组的信息
    * 参数:  
        - BigInteger seminarId (讨论课的id)   
        - BigInteger userId（用户的id）
    * 返回值: GroupBO  Group的相关信息
    * 调用的dao方法:
        - GroupDao. getGroupById(BigInteger seminarId，BigInteger userId)

4. String insertTopicByGroupId(BigInteger groupId, BigInteger topicId)
    * 方法简述：  小组按ID选择话题
    * 参数：  
        - groupId
        - topicId
    * 返回值：  url 
    * 调用的DAO方法：
        - topicDAO.insertTopicByGroupId(BigInteger groupId, BigInteger topicId)    

5. boolean deleteTopicByGroupId(BigInteger groupId)  
    * 方法简述：小组取消选择话题  
    * 参数：
        - groupId  
    * 返回值：true/false  
    * 调用的DAO方法：
        - topicDAO.deleteTopicByGroupId(BigInteger groupId)

6. GroupBO getFixedGroupById(BigInteger userId,BigInteger classId) 
    - 方法简述：按学生id和班级id获取学生所在小组
    - 参数：
        - 学生id
        - 班级id
    - 返回值：小组
    - 调用的Dao方法：
        - GroupDao.getFixedGroupById(BigInteger userId,BigInteger classId) 

### GradeService（类）
1. BigInteger countGradeByGroupId(BigInteger groupId)
    * 方法简述： 按ID获取小组讨论课成绩  
    * 参数： 
        - groupId
    * 返回值：groupId  
    * 调用的DAO方法：
        - gradeDAO.countGradeByGroupId(BigInteger groupId)  
        - gradeDAO.countPresentationGrade(BigInteger groupId,BigInteger seminarId)  

2. boolean updateGroupByGroupId(BigInteger groupId, BigInteger grade)(grade待定)
    * 方法简述：按ID设置小组报告分  
    * 参数：  
        - grade
        - groupId
    * 返回值：true/false  
    * 调用的DAO方法：
        - gradeDAO.updateGroupByGroupId(BigInteger groupId, BigInteger grade)

3. boolean insertGroupGradeByUserId(BigInteger groupId, BigInteger userId)  
    * 方法简述：提交对其他小组的打分  
    * 参数：  
        - userId
        - groupId
    * 返回值：true/false
    * 调用的DAO方法：
        - gradeDAO.insertGroupGradeByUserId(BigInteger groupId, BigInteger userId)
4. BigInteger countGradeByGroupId(BigInteger groupId)  
    * 方法简述： 按ID获取小组讨论课成绩  
    * 参数： 
        - groupId  
    * 返回值：groupId  
    * 调用的DAO方法：
        - gradeDAO.countGradeByGroupId(BigInteger groupId)  
        - gradeDAO.countPresentationGrade(BigInteger groupId,BigInteger seminarId)  

5. boolean updateGroupByGroupId(BigInteger groupId, BigInteger grade)  
    * 方法简述：按ID设置小组报告分  
    * 参数：  
        - grade
        - groupId  
    * 返回值：true/false  
    * 调用的DAO方法：
        - gradeDAO.updateGroupByGroupId(BigInteger groupId, BigInteger grade)  

6. boolean insertGroupGradeByUserId(BigInteger groupId, BigInteger userId)  
    * 方法简述：提交对其他小组的打分  
    * 参数：  
        - userId
        - groupId  
    * 返回值：true/false  
    * 调用的DAO方法：
        - gradeDAO.insertGroupGradeByUserId(BigInteger groupId, BigInteger userId)  
### ClassService（类）
1. List<ClassBO> listClassByName(String courseName,String teacherName)
    - 方法简述：按课程名称和教师名称获取班级列表
    - 参数：
        - 课程名称
        - 教师名称
    - 返回值：班级列表
    - 调用的Dao方法：
        - ClassDao.listClassByCourseName(BigInteger courseId)
        - ClassDao.listClassByTeacherName(String teacherName) 

2. ClassBO getClassByClassId(BigInteger classId) 
    - 方法简述：按班级id获取班级详情
    - 参数：
        - 班级id
    - 返回值：班级
    - 调用的Dao方法：
        - ClassDao.getClassByClassId(BigInteger classId)

3. boolean updateClassByClassId(BigInteger classId,ClassBO class)
    - 方法简述：按班级id和班级修改班级信息
    - 参数：
        - 班级id
        - 班级
    - 返回值：是否修改成功
    - 调用的Dao方法：
        - ClassDao.updateClassByClassId(BigInteger classId,ClassDO class) 

4. boolean deleteClassByClassId(BigInteger classId) 
    - 方法简述：按班级id删除班级
    - 参数：
        - 班级id
    - 返回值：是否删除成功
    - 调用的Dao方法：
        - ClassDao.deleteClassByClassId(BigInteger classId)

5. String insertStudentClassById(User user,BigInteger classId)
    - 方法简述：学生按班级id选择班级
    - 参数：
        - 学生
        - 班级id
    - 返回值：url字符串
    - 调用的Dao方法：
        - ClassDao.insertStudentClassById(User user,BigInteger classId) 

6. boolean deleteStudentClassById(BigInteger classId,BigInteger studentId)
    - 方法简述：学生按班级id和学生id取消班级选择
    - 参数：
        - 班级id
        - 学生id
    - 返回值：取消班级是否成功
    - 调用的Dao方法：
        - ClassDao.boolean deleteStudentClassById(BigInteger classId,BigInteger studentId)

7. ClassBO getCallGroupStatusById(BigInteger seminarId,BigInteger classId)
    * 方法简介:根据讨论课Id及班级id，获得该班级的签到、分组状态
    * 参数:  
        - BigInteger seminarId (讨论课的id) 
        - BigInteger classId（班级的id）
    * 返回值: ClassBO  班级的相关信息
    * 调用的dao方法:
        - SeminarDao.getSeminarBySeminarId(BigInteger seminarId)
        - ClassDao.getClassByClassId(BigInteger classId)

### AttendanceService（类）
1. Boolean updateAttendanceById(Biginteger seminarId,Biginteger classId,Biginteger userId,LocationBO location )
    * 方法简介:根据讨论课id及班级id，学生id，进行签到
    * 参数:  
        - BigInteger seminarId (讨论课的id)   
        - BigInteger classId（班级的id）
        - BigInteger userId (讨论课的id) 
        - LocationBO location 经纬度类
    * 返回值: 是否成功修改考勤状态
    * 调用的dao方法:
        - AttendanceDao.updateAttendanceById(integer seminarId,integer classId,integer userId,String status)  
### CourseService（类）：  
1. List<CourseBO> listCourseByUserId(BigIntegeruserId)//此id为数据库自动生成的id,id为用户id
    * 方法描述：按userId获取与当前用户相关联的课程列表
    * 参数 ：
        - userId
    * 返回值：课程列表
    * 调用的DAO方法：
        - List<Course> listCourseByUserId(BigInteger userId) 

2. BigInteger insertCourseByUserId(BigInteger userId,CourseBO course)  
    * 方法描述：按userId创建课程
    * 参数：
        - userId
        - course对象
    * 返回值：courseId
    * 调用的DAO方法：
        - Course insertCourseByUserId(BigInteger userId,CourseDO course)

3. CourseBO getCourseByCourseId(BigInteger courseId)
    * 方法描述：按courseId获取课程
    * 参数：
        - courseId
    * 返回值：course对象
    * 调用的DAO方法：
        - Course getCourseByCourseId(BigInteger courseId)

4. boolean updateCourseByCourseId(BigInteger courseId,CourseBO course)
    * 方法描述：按courseId修改课程
    * 参数：
        - courseId  
        - course对象
    * 返回值：boolean（用于判断是否修改成功）
    * 调用的DAO方法：
        - boolean updateCourseByCourseId(BigInteger courseId,CourseDO course)

5. boolean deleteCourseByCourseId(BigInteger courseId)
    * 方法描述：按courseId删除课程
    * 参数：
        - courseId
    * 返回值：boolean（用于判断是否删除成功）
    * 调用的DAO方法：
        - boolean deleteCourseByCourseId(BigInteger courseId)  
### SchoolService（类）： 
1. List<SchoolBO> listSchoolByCity(string city)
    * 方法描述：按城市名称查找学校
    * 参数：
        - string city
    * 返回值：学校列表
    * 调用的DAO方法：
        - List<School> listSchoolByCity(string city)

2. BigInteger insertSchool(School school)
    * 方法描述：添加学校
    * 参数：
        - school对象
    * 返回值：schoolId
    * 调用的DAO方法：
        - BigInteger insertSchool(School school)

3. List<ProvinceBO> listProvince()
    * 方法描述：获取省份列表
    * 参数：无
    * 返回值：省份列表
    * 调用的DAO方法：
        - List<Province> listProvince()

4. List<CityBO> listCity(string province)
    * 方法描述：获取城市列表
    * 参数：
        - string province
    * 返回值：城市列表
	* 调用的DAO方法：
        - List<CityDO> listCity(string province)  