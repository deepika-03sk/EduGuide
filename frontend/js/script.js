/* =========================================================
   EDUGUIDE - COMPLETE FRONTEND JAVASCRIPT
   =========================================================
   
   Supports:
   1. Stream Explorer
   2. Course Explorer
   3. Career Explorer
   4. Entrance Exam Explorer
   5. College Explorer
   6. Scholarship Explorer
   7. Education Pathway Explorer

   Backend:
   Spring Boot
   http://localhost:8080
   ========================================================= */


document.addEventListener("DOMContentLoaded", () => {


    /* =====================================================
       GLOBAL DATA
       ===================================================== */

    let streams = [];

    let allCourses = [];


    /* =====================================================
       STATIC CAREER DATA
       ===================================================== */

    const careerData = {

        "Software Engineer": {

            field: "Computer Science / Engineering",

            stream: "MPC",

            education: "B.Tech / B.E. in Computer Science or related field",

            description:
                "Software Engineers design, develop, test and maintain software applications and systems.",

            skills:
                "Java, Python, Data Structures, Algorithms, SQL, Git and problem solving",

            opportunities:
                "Software development, backend development, frontend development, mobile applications and cloud technologies"

        },


        "Data Scientist": {

            field: "Computer Science / Data Science",

            stream: "MPC",

            education: "B.Tech / B.Sc. / BCA with relevant data science skills",

            description:
                "Data Scientists use data, statistics and machine learning techniques to solve real-world problems.",

            skills:
                "Python, Statistics, SQL, Machine Learning, Pandas, NumPy and Data Visualization",

            opportunities:
                "Data science, analytics, machine learning and artificial intelligence"

        },


        "Doctor": {

            field: "Medicine",

            stream: "BiPC",

            education: "MBBS followed by further specialization if desired",

            description:
                "Doctors diagnose illnesses, provide treatment and help patients maintain and improve their health.",

            skills:
                "Medical knowledge, communication, decision making, observation and patient care",

            opportunities:
                "Hospitals, clinics, healthcare organizations, research and specialization"

        },


        "Pharmacist": {

            field: "Pharmacy",

            stream: "BiPC",

            education: "B.Pharm / D.Pharm",

            description:
                "Pharmacists work with medicines, their preparation, safe use and appropriate dispensing.",

            skills:
                "Pharmaceutical knowledge, chemistry, communication and attention to detail",

            opportunities:
                "Hospitals, pharmacies, pharmaceutical companies, research and quality control"

        },


        "Civil Engineer": {

            field: "Engineering",

            stream: "MPC",

            education: "B.Tech / B.E. in Civil Engineering",

            description:
                "Civil Engineers plan, design and supervise infrastructure such as buildings, roads and bridges.",

            skills:
                "Engineering mathematics, CAD, structural concepts, planning and project management",

            opportunities:
                "Construction, infrastructure, structural engineering, transportation and government projects"

        },


        "Business Analyst": {

            field: "Management / Commerce",

            stream: "MEC / CEC",

            education: "B.Com / BBA / Engineering or related degree with analytical skills",

            description:
                "Business Analysts study business requirements, processes and data to help organizations make better decisions.",

            skills:
                "Data analysis, Excel, SQL, communication, problem solving and business understanding",

            opportunities:
                "Business analysis, consulting, product management, operations and analytics"

        }

    };


    /* =====================================================
       STATIC EXAM DATA
       ===================================================== */

    const examData = {

        "JEE Main": {

            purpose: "Engineering and technology admissions",

            stream: "MPC",

            field: "Engineering",

            description:
                "JEE Main is an entrance examination used for admission to participating undergraduate engineering and technology programmes.",

            preparation:
                "Focus on Physics, Chemistry and Mathematics concepts, problem solving and regular practice.",

            nextStep:
                "Use your result and applicable counselling process to explore eligible engineering colleges and courses."

        },


        "NEET UG": {

            purpose: "Undergraduate medical admissions",

            stream: "BiPC",

            field: "Medicine",

            description:
                "NEET UG is a national entrance examination associated with undergraduate medical admissions.",

            preparation:
                "Focus on Biology, Physics and Chemistry with strong conceptual understanding and regular mock tests.",

            nextStep:
                "Use your result and applicable counselling process to explore medical education opportunities."

        },


        "AP EAPCET": {

            purpose: "Engineering, agriculture and pharmacy admissions in Andhra Pradesh",

            stream: "MPC / BiPC",

            field: "Engineering / Agriculture / Pharmacy",

            description:
                "AP EAPCET is a state-level entrance examination associated with professional undergraduate admissions in Andhra Pradesh.",

            preparation:
                "Prepare the relevant subjects according to the examination pattern and practise previous questions and mock tests.",

            nextStep:
                "After the examination, follow the applicable counselling process to explore participating institutions."

        },


        "CUET UG": {

            purpose: "Undergraduate university admissions",

            stream: "Multiple Streams",

            field: "Multiple Fields",

            description:
                "CUET UG is a common entrance examination used by participating universities for undergraduate admissions.",

            preparation:
                "Understand the subjects required for your target programmes and practise the relevant question types.",

            nextStep:
                "Check participating universities and programme-specific eligibility before applying."

        },


        "CLAT": {

            purpose: "Undergraduate law admissions",

            stream: "CEC / Multiple Streams",

            field: "Law",

            description:
                "CLAT is an entrance examination associated with undergraduate law admissions at participating national law universities.",

            preparation:
                "Develop reading comprehension, logical reasoning, legal reasoning, quantitative techniques and current affairs awareness.",

            nextStep:
                "Use your result and counselling process to explore participating law universities."

        },


        "NATA": {

            purpose: "Architecture admissions",

            stream: "MPC",

            field: "Architecture",

            description:
                "NATA is an aptitude examination used for admission to undergraduate architecture programmes.",

            preparation:
                "Work on mathematics, general aptitude, visual reasoning and drawing-related skills.",

            nextStep:
                "Explore architecture institutions and check their current admission requirements."

        }

    };


    /* =====================================================
       STATIC COLLEGE DATA
       ===================================================== */

    const collegeData = {

        "IIT Hyderabad": {

            location: "Hyderabad, Telangana",

            type: "Institute of National Importance",

            area: "Engineering, Science and Technology",

            description:
                "An institute offering undergraduate, postgraduate and research programmes in engineering, science and technology.",

            admissions:
                "Admission requirements depend on the programme and applicable entrance examination.",

            opportunities:
                "Engineering, technology, science, research and higher studies"

        },


        "NIT Warangal": {

            location: "Warangal, Telangana",

            type: "National Institute",

            area: "Engineering and Technology",

            description:
                "A leading technical institution offering programmes in engineering, technology and related disciplines.",

            admissions:
                "Admission requirements depend on the programme and applicable national admission process.",

            opportunities:
                "Engineering, technology, research, placements and higher studies"

        },


        "Andhra University": {

            location: "Visakhapatnam, Andhra Pradesh",

            type: "University",

            area: "Multiple Disciplines",

            description:
                "A university offering programmes across science, engineering, arts, commerce and other disciplines.",

            admissions:
                "Admission requirements vary according to the programme.",

            opportunities:
                "Higher education, research, professional education and multidisciplinary studies"

        },


        "JNTU Kakinada": {

            location: "Kakinada, Andhra Pradesh",

            type: "Technical University",

            area: "Engineering and Technology",

            description:
                "A technical university known for engineering, technology and professional education.",

            admissions:
                "Admission requirements vary according to the programme and applicable entrance process.",

            opportunities:
                "Engineering, technology, research, professional education and placements"

        },


        "Osmania University": {

            location: "Hyderabad, Telangana",

            type: "University",

            area: "Multiple Disciplines",

            description:
                "A multidisciplinary university offering programmes in science, arts, commerce, law and technology.",

            admissions:
                "Admission requirements depend on the selected programme.",

            opportunities:
                "Higher education, research and professional career pathways"

        },


        "Sri Venkateswara University": {

            location: "Tirupati, Andhra Pradesh",

            type: "University",

            area: "Multiple Disciplines",

            description:
                "A university offering undergraduate and postgraduate education across multiple academic disciplines.",

            admissions:
                "Admission requirements depend on the programme and applicable admission process.",

            opportunities:
                "Higher education, research and multidisciplinary career pathways"

        }

    };


    /* =====================================================
       STATIC SCHOLARSHIP DATA
       ===================================================== */

    const scholarshipData = {

        "National Scholarship Scheme": {

            category: "Government / Higher Education",

            level: "Higher Education",

            eligibility:
                "Eligibility depends on the specific scholarship scheme, academic requirements and other applicable conditions.",

            support:
                "Financial assistance towards eligible educational expenses.",

            application:
                "Students should verify the current scheme details and application procedure through the official scholarship portal."

        },


        "Post-Matric Scholarship": {

            category: "Post-Matric",

            level: "Higher Education",

            eligibility:
                "Eligibility depends on the applicable scheme, student category, income criteria and academic requirements.",

            support:
                "Financial assistance for eligible students continuing education after secondary schooling.",

            application:
                "Check the applicable government or institutional scholarship portal for current application information."

        },


        "Merit Scholarship": {

            category: "Merit",

            level: "Higher Education",

            eligibility:
                "Generally based on academic performance along with other scheme-specific requirements.",

            support:
                "Financial support for eligible students demonstrating academic merit.",

            application:
                "Check the scholarship provider's current eligibility and application procedure."

        },


        "Scholarship for Girl Students": {

            category: "Student Support",

            level: "Higher Education",

            eligibility:
                "Eligibility depends on the specific scholarship programme and its applicable requirements.",

            support:
                "Financial assistance intended to support eligible girls pursuing education.",

            application:
                "Verify current opportunities through official scholarship providers and portals."

        },


        "Engineering Scholarships": {

            category: "Engineering / Technical",

            level: "Higher Education",

            eligibility:
                "Requirements vary by scholarship provider, academic performance, income and other applicable conditions.",

            support:
                "Financial assistance opportunities for eligible engineering students.",

            application:
                "Check the current scholarship provider requirements before applying."

        },


        "Minority Student Scholarships": {

            category: "Financial Aid",

            level: "Higher Education",

            eligibility:
                "Eligibility depends on the specific scheme and its applicable requirements.",

            support:
                "Financial assistance opportunities for eligible students under applicable scholarship programmes.",

            application:
                "Verify current eligibility, documents and deadlines through the official scholarship source."

        }

    };


    /* =====================================================
       STATIC PATHWAY DATA
       ===================================================== */

    const pathwayData = {

        "MPC → CSE → Software Engineer": {

            steps: [
                ["Step 1", "MPC", "10+2 Stream"],
                ["Step 2", "Computer Science Engineering", "Undergraduate Course"],
                ["Step 3", "Higher Studies / Skills", "Optional Specialization"],
                ["Step 4", "Software Engineer", "Career"]
            ],

            description:
                "This pathway connects a mathematics-based +2 stream with computer science education and software development careers.",

            skills:
                "Programming, Data Structures, Algorithms, Databases, Web Development and Software Engineering"

        },


        "BiPC → MBBS → Doctor": {

            steps: [
                ["Step 1", "BiPC", "10+2 Stream"],
                ["Step 2", "MBBS", "Medical Course"],
                ["Step 3", "Internship / Higher Studies", "Professional Development"],
                ["Step 4", "Doctor", "Career"]
            ],

            description:
                "This pathway is suitable for students interested in biology, medicine, healthcare and patient care.",

            skills:
                "Biology, Medical Science, Communication, Clinical Skills and Patient Care"

        },


        "BiPC → B.Pharm → Pharmacist": {

            steps: [
                ["Step 1", "BiPC", "10+2 Stream"],
                ["Step 2", "B.Pharm", "Undergraduate Course"],
                ["Step 3", "Professional Practice / Higher Studies", "Career Preparation"],
                ["Step 4", "Pharmacist", "Career"]
            ],

            description:
                "This pathway combines biology and pharmaceutical sciences with careers related to medicines and healthcare.",

            skills:
                "Pharmaceutical Science, Chemistry, Pharmacology, Communication and Attention to Detail"

        },


        "MEC → B.Com → Business Analyst": {

            steps: [
                ["Step 1", "MEC", "10+2 Stream"],
                ["Step 2", "B.Com", "Undergraduate Course"],
                ["Step 3", "Analytics Skills", "Skill Development"],
                ["Step 4", "Business Analyst", "Career"]
            ],

            description:
                "This pathway combines commerce education with analytical and business skills.",

            skills:
                "Accounting, Business Analysis, Excel, SQL, Communication and Problem Solving"

        },


        "CEC → Law → Legal Professional": {

            steps: [
                ["Step 1", "CEC", "10+2 Stream"],
                ["Step 2", "Law", "Law Education"],
                ["Step 3", "Professional Training", "Career Preparation"],
                ["Step 4", "Legal Professional", "Career"]
            ],

            description:
                "This pathway is suitable for students interested in law, legal studies, public policy and related careers.",

            skills:
                "Reading, Reasoning, Communication, Research and Legal Analysis"

        },


        "Arts → Social Sciences → Research": {

            steps: [
                ["Step 1", "Arts / Humanities", "10+2 Stream"],
                ["Step 2", "Social Sciences", "Undergraduate Course"],
                ["Step 3", "Higher Studies", "Specialization"],
                ["Step 4", "Research", "Career"]
            ],

            description:
                "This pathway connects humanities and social science education with research and academic opportunities.",

            skills:
                "Research, Critical Thinking, Writing, Data Interpretation and Communication"

        }

    };


    /* =====================================================
       LOAD BACKEND DATA
       ===================================================== */

    async function loadEduGuideData() {

        try {

            const response =
                await fetch("http://localhost:8080/api/streams");


            if (!response.ok) {

                throw new Error(
                    "Unable to load EduGuide backend data"
                );

            }


            streams = await response.json();


            console.log(
                "EduGuide backend data loaded:",
                streams
            );


            /* ---------------------------------------------
               Build one course list from all fields
               --------------------------------------------- */

            allCourses = [];


            streams.forEach(stream => {

                if (!stream.fields) {
                    return;
                }


                stream.fields.forEach(field => {

                    if (!field.courses) {
                        return;
                    }


                    field.courses.forEach(course => {

                        allCourses.push({

                            ...course,

                            fieldName:
                                field.name,

                            streamName:
                                stream.name

                        });

                    });

                });

            });


            console.log(
                "Courses loaded:",
                allCourses
            );


            initializeStreamExplorer();

            initializeCourseExplorer();


        } catch (error) {

            console.error(
                "EduGuide backend connection failed:",
                error
            );


            initializeStreamExplorer();

            initializeCourseExplorer();

        }

    }


    /* =====================================================
       STREAM EXPLORER
       ===================================================== */

    function initializeStreamExplorer() {

        const streamGrid =
            document.getElementById("streamGrid");

        const streamSearch =
            document.getElementById("streamSearch");

        const noResults =
            document.getElementById("noResults");

        const selectedStreamName =
            document.getElementById(
                "selectedStreamName"
            );

        const fieldGrid =
            document.getElementById("fieldGrid");

        const streamCount =
            document.getElementById("streamCount");


        if (!streamGrid || !streamSearch) {
            return;
        }


        const cards =
            streamGrid.querySelectorAll(
                ".stream-card"
            );


        cards.forEach(card => {

            const cardStream =
                card.dataset.stream;


            const backendStream =
                streams.find(stream =>
                    normalizeStreamName(stream.name)
                    === cardStream
                );


            if (backendStream) {

                card.dataset.streamId =
                    backendStream.id;

                card.dataset.streamName =
                    backendStream.name;

            }

        });


        if (
            streamCount &&
            streams.length > 0
        ) {

            streamCount.textContent =
                `${streams.length} streams available`;

        }


        /* ---------------------------------------------
           SEARCH
           --------------------------------------------- */

        streamSearch.addEventListener(
            "input",
            () => {

                const searchText =
                    streamSearch.value
                        .trim()
                        .toLowerCase();


                let visibleCards = 0;


                cards.forEach(card => {

                    const title =
                        card.querySelector("h3")
                            ?.textContent
                            .toLowerCase() || "";


                    const description =
                        card.querySelector("p")
                            ?.textContent
                            .toLowerCase() || "";


                    const tags =
                        card.querySelector(
                            ".stream-tags"
                        )
                            ?.textContent
                            .toLowerCase() || "";


                    const matches =
                        title.includes(searchText) ||
                        description.includes(searchText) ||
                        tags.includes(searchText);


                    if (matches) {

                        card.style.display = "";

                        visibleCards++;

                    } else {

                        card.style.display = "none";

                    }

                });


                if (noResults) {

                    noResults.style.display =
                        visibleCards === 0
                            ? "block"
                            : "none";

                }

            }
        );


        /* ---------------------------------------------
           VIEW STREAM
           --------------------------------------------- */

        streamGrid.addEventListener(
            "click",
            event => {

                const button =
                    event.target.closest(
                        ".stream-explore-btn"
                    );


                if (!button) {
                    return;
                }


                const card =
                    button.closest(".stream-card");


                if (!card) {
                    return;
                }


                const streamId =
                    card.dataset.streamId;


                const streamName =
                    card.dataset.streamName ||
                    card.querySelector("h3")
                        ?.textContent ||
                    "Selected Stream";


                if (selectedStreamName) {

                    selectedStreamName.textContent =
                        streamName;

                }


                const selectedStream =
                    streams.find(stream =>
                        String(stream.id) ===
                        String(streamId)
                    );


                if (selectedStream) {

                    displayFields(
                        selectedStream,
                        fieldGrid
                    );

                } else {

                    showBackendMessage(
                        fieldGrid
                    );

                }


                const details =
                    document.getElementById(
                        "streamDetails"
                    );


                if (details) {

                    details.scrollIntoView({
                        behavior: "smooth",
                        block: "start"
                    });

                }

            }
        );

    }


    /* =====================================================
       DISPLAY STREAM FIELDS
       ===================================================== */

    function displayFields(
        stream,
        fieldGrid
    ) {

        if (!fieldGrid) {
            return;
        }


        fieldGrid.innerHTML = "";


        if (
            !stream.fields ||
            stream.fields.length === 0
        ) {

            fieldGrid.innerHTML = `

                <div class="empty-field-state">

                    <div class="empty-icon">
                        ◇
                    </div>

                    <h3>
                        No fields available yet
                    </h3>

                    <p>
                        More information will be
                        added to EduGuide soon.
                    </p>

                </div>

            `;

            return;

        }


        stream.fields.forEach(
            (field, index) => {

                const fieldCard =
                    document.createElement(
                        "div"
                    );


                fieldCard.className =
                    "field-card";


                const courses =
                    field.courses || [];


                let courseHTML = "";


                if (courses.length > 0) {

                    courseHTML =
                        courses
                            .map(course => {

                                return `
                                    <div>
                                        ${escapeHTML(
                                            course.name
                                        )}
                                    </div>
                                `;

                            })
                            .join("");

                } else {

                    courseHTML = `
                        <div>
                            Courses will be added soon
                        </div>
                    `;

                }


                fieldCard.innerHTML = `

                    <div class="field-card-icon">
                        ${getFieldIcon(index)}
                    </div>

                    <h3>
                        ${escapeHTML(
                            field.name
                        )}
                    </h3>

                    <p>
                        ${escapeHTML(
                            field.description ||
                            "Explore opportunities in this field."
                        )}
                    </p>

                    <div class="field-course-title">
                        COURSES
                    </div>

                    <div class="field-course-list">
                        ${courseHTML}
                    </div>

                `;


                fieldGrid.appendChild(
                    fieldCard
                );

            }
        );

    }


    /* =====================================================
       COURSE EXPLORER
       ===================================================== */

    function initializeCourseExplorer() {

        const courseGrid =
            document.getElementById("courseGrid");

        const courseSearch =
            document.getElementById("courseSearch");


        if (!courseGrid || !courseSearch) {
            return;
        }


        renderCourses(allCourses);


        courseSearch.addEventListener(
            "input",
            () => {

                const searchText =
                    courseSearch.value
                        .trim()
                        .toLowerCase();


                const filteredCourses =
                    allCourses.filter(course => {

                        const name =
                            String(
                                course.name || ""
                            ).toLowerCase();


                        const description =
                            String(
                                course.description || ""
                            ).toLowerCase();


                        const field =
                            String(
                                course.fieldName || ""
                            ).toLowerCase();


                        const stream =
                            String(
                                course.streamName || ""
                            ).toLowerCase();


                        return (
                            name.includes(searchText) ||
                            description.includes(searchText) ||
                            field.includes(searchText) ||
                            stream.includes(searchText)
                        );

                    });


                renderCourses(
                    filteredCourses
                );

            }
        );

    }


    /* =====================================================
       RENDER COURSES
       ===================================================== */

    function renderCourses(courses) {

        const courseGrid =
            document.getElementById(
                "courseGrid"
            );

        const courseCount =
            document.getElementById(
                "courseCount"
            );

        const courseNoResults =
            document.getElementById(
                "courseNoResults"
            );


        if (!courseGrid) {
            return;
        }


        courseGrid.innerHTML = "";


        if (courseCount) {

            courseCount.textContent =
                `${courses.length} courses available`;

        }


        if (courses.length === 0) {

            if (courseNoResults) {

                courseNoResults.style.display =
                    "block";

            }

            return;

        }


        if (courseNoResults) {

            courseNoResults.style.display =
                "none";

        }


        courses.forEach(
            (course, index) => {

                const card =
                    document.createElement(
                        "div"
                    );


                card.className =
                    "course-card";


                card.dataset.courseId =
                    course.id;


                card.innerHTML = `

                    <div class="course-card-top">

                        <div class="course-icon">
                            ${getCourseIcon(index)}
                        </div>

                        <span class="course-code">
                            ${String(
                                index + 1
                            ).padStart(2, "0")}
                        </span>

                    </div>


                    <h3>
                        ${escapeHTML(
                            course.name
                        )}
                    </h3>


                    <p class="course-card-description">
                        ${escapeHTML(
                            course.description ||
                            "Explore this course and its opportunities."
                        )}
                    </p>


                    <div class="course-meta">

                        <span>
                            ${escapeHTML(
                                course.duration ||
                                "Duration available soon"
                            )}
                        </span>

                        <span>
                            ${escapeHTML(
                                course.fieldName ||
                                "Field"
                            )}
                        </span>

                    </div>


                    <button
                        class="course-view-btn"
                        type="button"
                    >
                        View details
                        <span>→</span>
                    </button>

                `;


                courseGrid.appendChild(
                    card
                );

            }
        );


        courseGrid.onclick = event => {

            const button =
                event.target.closest(
                    ".course-view-btn"
                );


            if (!button) {
                return;
            }


            const card =
                button.closest(".course-card");


            if (!card) {
                return;
            }


            const courseId =
                card.dataset.courseId;


            const selectedCourse =
                allCourses.find(course =>
                    String(course.id) ===
                    String(courseId)
                );


            if (selectedCourse) {

                displayCourseDetails(
                    selectedCourse
                );

            }

        };

    }


    /* =====================================================
       COURSE DETAILS
       ===================================================== */

    function displayCourseDetails(
        course
    ) {

        const selectedCourseName =
            document.getElementById(
                "selectedCourseName"
            );


        const detailContent =
            document.getElementById(
                "courseDetailContent"
            );


        if (!detailContent) {
            return;
        }


        if (selectedCourseName) {

            selectedCourseName.textContent =
                course.name;

        }


        detailContent.innerHTML = `

            <div class="course-detail-panel">

                <div class="course-detail-box">

                    <span>
                        Duration
                    </span>

                    <strong>
                        ${escapeHTML(
                            course.duration ||
                            "Not specified"
                        )}
                    </strong>

                </div>


                <div class="course-detail-box">

                    <span>
                        Field
                    </span>

                    <strong>
                        ${escapeHTML(
                            course.fieldName ||
                            "Not specified"
                        )}
                    </strong>

                </div>


                <div class="course-detail-box">

                    <span>
                        Stream
                    </span>

                    <strong>
                        ${escapeHTML(
                            course.streamName ||
                            "Not specified"
                        )}
                    </strong>

                </div>

            </div>


            <div class="course-description-box">

                <h3>
                    Eligibility
                </h3>

                <p>
                    ${escapeHTML(
                        course.eligibility ||
                        "Eligibility information will be added soon."
                    )}
                </p>


                <h3>
                    About the Course
                </h3>

                <p>
                    ${escapeHTML(
                        course.description ||
                        "Course description will be added soon."
                    )}
                </p>

            </div>

        `;


        scrollToElement("courseDetails");

    }


    /* =====================================================
       CAREER EXPLORER
       ===================================================== */

   async function initializeCareerExplorer() {

    const careerGrid =
        document.getElementById("careerGrid");

    const careerSearch =
        document.getElementById("careerSearch");

    const careerNoResults =
        document.getElementById("careerNoResults");

    const careerCount =
        document.getElementById("careerCount");

    if (!careerGrid || !careerSearch) {
        return;
    }

    try {

        const response =
            await fetch("http://localhost:8080/api/careers");

        if (!response.ok) {
            throw new Error("Unable to load careers");
        }

        const careers =
            await response.json();

        console.log("Careers loaded from backend:", careers);

        renderCareers(careers);

        careerSearch.addEventListener("input", () => {

            const searchText =
                careerSearch.value
                    .trim()
                    .toLowerCase();

            const filteredCareers =
                careers.filter(career => {

                    const name =
                        String(career.name || "")
                            .toLowerCase();

                    const field =
                        String(career.field || "")
                            .toLowerCase();

                    const stream =
                        String(career.stream || "")
                            .toLowerCase();

                    const description =
                        String(career.description || "")
                            .toLowerCase();

                    return (
                        name.includes(searchText) ||
                        field.includes(searchText) ||
                        stream.includes(searchText) ||
                        description.includes(searchText)
                    );
                });

            renderCareers(filteredCareers);
        });

    } catch (error) {

        console.error(
            "Career backend connection failed:",
            error
        );

        careerGrid.innerHTML = `
            <div class="career-empty-state">
                <h3>
                    Unable to load careers
                </h3>

                <p>
                    Please start the Spring Boot backend
                    and try again.
                </p>
            </div>
        `;
    }

    function renderCareers(careers) {

        careerGrid.innerHTML = "";

        if (careerCount) {
            careerCount.textContent =
                `${careers.length} careers available`;
        }

        if (careers.length === 0) {

            if (careerNoResults) {
                careerNoResults.style.display =
                    "block";
            }

            return;
        }

        if (careerNoResults) {
            careerNoResults.style.display =
                "none";
        }

        careers.forEach((career, index) => {

            const card =
                document.createElement("div");

            card.className = "career-card";

            card.innerHTML = `
                <div class="career-card-top">

                    <div class="career-icon">
                        ${getCourseIcon(index)}
                    </div>

                    <span class="career-code">
                        ${String(index + 1).padStart(2, "0")}
                    </span>

                </div>

                <h3>
                    ${escapeHTML(career.name)}
                </h3>

                <p>
                    ${escapeHTML(
                        career.description ||
                        "Explore this career and its opportunities."
                    )}
                </p>

                <div class="career-tags">
                    <span>
                        ${escapeHTML(career.field || "Field")}
                    </span>

                    <span>
                        ${escapeHTML(career.stream || "Stream")}
                    </span>
                </div>

                <button
                    class="career-view-btn"
                    type="button"
                    data-career-id="${career.id}"
                >
                    View details
                    <span>→</span>
                </button>
            `;

            careerGrid.appendChild(card);
        });

        careerGrid.onclick = event => {

            const button =
                event.target.closest(
                    ".career-view-btn"
                );

            if (!button) {
                return;
            }

            const careerId =
                button.dataset.careerId;

            const selectedCareer =
                careers.find(career =>
                    String(career.id) ===
                    String(careerId)
                );

            if (selectedCareer) {
                displayCareerDetails(
                    selectedCareer
                );
            }
        };
    }

    function displayCareerDetails(career) {

        const selectedCareerName =
            document.getElementById(
                "selectedCareerName"
            );

        const detailContent =
            document.getElementById(
                "careerDetailContent"
            );

        if (!detailContent) {
            return;
        }

        if (selectedCareerName) {
            selectedCareerName.textContent =
                career.name;
        }

        detailContent.innerHTML = `
            <div class="career-detail-panel">

                <div class="career-detail-box">
                    <span>
                        FIELD
                    </span>

                    <strong>
                        ${escapeHTML(
                            career.field ||
                            "Not specified"
                        )}
                    </strong>
                </div>

                <div class="career-detail-box">
                    <span>
                        STREAM
                    </span>

                    <strong>
                        ${escapeHTML(
                            career.stream ||
                            "Not specified"
                        )}
                    </strong>
                </div>

                <div class="career-detail-box">
                    <span>
                        EDUCATION
                    </span>

                    <strong>
                        ${escapeHTML(
                            career.education ||
                            "Not specified"
                        )}
                    </strong>
                </div>

            </div>

            <div class="career-description-box">

                <h3>
                    About the Career
                </h3>

                <p>
                    ${escapeHTML(
                        career.description ||
                        "Description not available."
                    )}
                </p>

                <h3>
                    Important Skills
                </h3>

                <p>
                    ${escapeHTML(
                        career.skills ||
                        "Skills information not available."
                    )}
                </p>

                <h3>
                    Career Opportunities
                </h3>

                <p>
                    ${escapeHTML(
                        career.opportunities ||
                        "Opportunity information not available."
                    )}
                </p>

            </div>
        `;

        scrollToElement("careerDetails");
    }
}


    /* =====================================================
       EXAM EXPLORER
       ===================================================== */

   /* =====================================================
   EXAM EXPLORER
   ===================================================== */

async function initializeExamExplorer() {

    const examGrid =
        document.getElementById("examGrid");

    const examSearch =
        document.getElementById("examSearch");

    const examNoResults =
        document.getElementById("examNoResults");

    const examCount =
        document.getElementById("examCount");


    if (!examGrid || !examSearch) {
        return;
    }


    try {

        const response =
            await fetch(
                "http://localhost:8080/api/exams"
            );


        if (!response.ok) {

            throw new Error(
                "Unable to load exams"
            );

        }


        const exams =
            await response.json();


        console.log(
            "Exams loaded:",
            exams
        );


        /* ---------------------------------------------
           DISPLAY EXAM COUNT
           --------------------------------------------- */

        if (examCount) {

            examCount.textContent =
                `${exams.length} exams available`;

        }


        /* ---------------------------------------------
           CREATE EXAM CARDS
           --------------------------------------------- */

        examGrid.innerHTML = "";


        exams.forEach(exam => {

            const card =
                document.createElement("div");

            card.className =
                "exam-card";

            card.dataset.examId =
                exam.id;


            card.innerHTML = `

                <div class="exam-icon">
                    ◉
                </div>

                <h3>
                    ${escapeHTML(exam.name)}
                </h3>

                <p>
                    ${escapeHTML(
                        exam.description ||
                        "Exam information available."
                    )}
                </p>

                <div class="exam-tags">

                    <span>
                        ${escapeHTML(
                            exam.stream ||
                            "All Streams"
                        )}
                    </span>

                    <span>
                        ${escapeHTML(
                            exam.level ||
                            "National"
                        )}
                    </span>

                </div>

                <button
                    class="exam-view-btn"
                    type="button"
                >
                    View Details →
                </button>

            `;


            examGrid.appendChild(card);

        });


        /* ---------------------------------------------
           SEARCH
           --------------------------------------------- */

        examSearch.addEventListener(
            "input",
            () => {

                const searchText =
                    examSearch.value
                        .trim()
                        .toLowerCase();


                let visibleCards = 0;


                const cards =
                    examGrid.querySelectorAll(
                        ".exam-card"
                    );


                cards.forEach(card => {

                    const examId =
                        card.dataset.examId;


                    const exam =
                        exams.find(item =>
                            String(item.id) ===
                            String(examId)
                        );


                    if (!exam) {
                        return;
                    }


                    const searchableText = [

                        exam.name,
                        exam.conductingBody,
                        exam.stream,
                        exam.eligibility,
                        exam.level,
                        exam.description,
                        exam.purpose

                    ]
                        .filter(Boolean)
                        .join(" ")
                        .toLowerCase();


                    const matches =
                        searchableText.includes(
                            searchText
                        );


                    card.style.display =
                        matches ? "" : "none";


                    if (matches) {
                        visibleCards++;
                    }

                });


                if (examNoResults) {

                    examNoResults.style.display =
                        visibleCards === 0
                            ? "block"
                            : "none";

                }

            }
        );


        /* ---------------------------------------------
           VIEW EXAM DETAILS
           --------------------------------------------- */

        examGrid.addEventListener(
            "click",
            event => {

                const button =
                    event.target.closest(
                        ".exam-view-btn"
                    );


                if (!button) {
                    return;
                }


                const card =
                    button.closest(
                        ".exam-card"
                    );


                if (!card) {
                    return;
                }


                const examId =
                    card.dataset.examId;


                const selectedExam =
                    exams.find(exam =>
                        String(exam.id) ===
                        String(examId)
                    );


                if (selectedExam) {

                    displayExamDetails(
                        selectedExam
                    );

                }

            }
        );


    } catch (error) {

        console.error(
            "Exam backend connection failed:",
            error
        );


        examGrid.innerHTML = `

            <div class="exam-empty-state">

                <h3>
                    Unable to load exams
                </h3>

                <p>
                    Please start the Spring Boot
                    backend and try again.
                </p>

            </div>

        `;

    }

}


/* =====================================================
   EXAM DETAILS
   ===================================================== */

function displayExamDetails(exam) {

    const selectedExamName =
        document.getElementById(
            "selectedExamName"
        );


    const detailContent =
        document.getElementById(
            "examDetailContent"
        );


    if (!detailContent) {
        return;
    }


    if (selectedExamName) {

        selectedExamName.textContent =
            exam.name;

    }


    detailContent.innerHTML = `

        <div class="exam-detail-panel">

            <div class="exam-detail-box">

                <span>
                    CONDUCTING BODY
                </span>

                <strong>
                    ${escapeHTML(
                        exam.conductingBody ||
                        "Not specified"
                    )}
                </strong>

            </div>


            <div class="exam-detail-box">

                <span>
                    STREAM
                </span>

                <strong>
                    ${escapeHTML(
                        exam.stream ||
                        "Not specified"
                    )}
                </strong>

            </div>


            <div class="exam-detail-box">

                <span>
                    LEVEL
                </span>

                <strong>
                    ${escapeHTML(
                        exam.level ||
                        "Not specified"
                    )}
                </strong>

            </div>

        </div>


        <div class="exam-description-box">

            <h3>
                Eligibility
            </h3>

            <p>
                ${escapeHTML(
                    exam.eligibility ||
                    "Eligibility information will be added soon."
                )}
            </p>


            <h3>
                About the Exam
            </h3>

            <p>
                ${escapeHTML(
                    exam.description ||
                    "Exam description will be added soon."
                )}
            </p>


            <h3>
                Purpose
            </h3>

            <p>
                ${escapeHTML(
                    exam.purpose ||
                    "Purpose information will be added soon."
                )}
            </p>


            <h3>
                Official Website
            </h3>

            <p>

                ${
                    exam.website
                        ? `
                            <a
                                href="${exam.website}"
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                Visit Official Website →
                                 ${escapeHTML(exam.website)}
                            </a>
                          `
                        : "Website information will be added soon."
                }

            </p>

        </div>

    `;


    scrollToElement("examDetails");

}


    /* =====================================================
       COLLEGE EXPLORER
       ===================================================== */

    /* =====================================================
   COLLEGE EXPLORER
   ===================================================== */

async function initializeCollegeExplorer() {

    const collegeGrid =
        document.getElementById("collegeGrid");

    const collegeSearch =
        document.getElementById("collegeSearch");

    const collegeNoResults =
        document.getElementById("collegeNoResults");

    const collegeCount =
        document.getElementById("collegeCount");


    if (!collegeGrid || !collegeSearch) {
        return;
    }


    try {

        const response =
            await fetch(
                "http://localhost:8080/api/colleges"
            );


        if (!response.ok) {
            throw new Error("Unable to load colleges");
        }


        const colleges =
            await response.json();

        console.log(
            "Colleges loaded:",
            colleges
        );


        if (collegeCount) {
            collegeCount.textContent =
                `${colleges.length} colleges available`;
        }


        collegeGrid.innerHTML = "";


        colleges.forEach(college => {

            const card =
                document.createElement("div");

            card.className =
                "college-card";

            card.dataset.collegeId =
                college.id;


            card.innerHTML = `

                <div class="college-icon">
                    🏫
                </div>

                <h3>
                    ${escapeHTML(college.name)}
                </h3>

                <p>
                    ${escapeHTML(
                        college.description ||
                        "College information available."
                    )}
                </p>

                <div class="college-tags">

                    <span>
                        ${escapeHTML(
                            college.state ||
                            "State not specified"
                        )}
                    </span>

                    <span>
                        ${escapeHTML(
                            college.type ||
                            "Institution"
                        )}
                    </span>

                </div>

                <button
                    class="college-view-btn"
                    type="button"
                >
                    View Details →
                </button>

            `;


            collegeGrid.appendChild(card);
        });


        /* =========================
           SEARCH
           ========================= */

        collegeSearch.addEventListener(
            "input",
            () => {

                const searchText =
                    collegeSearch.value
                        .trim()
                        .toLowerCase();


                let visibleCards = 0;


                const cards =
                    collegeGrid.querySelectorAll(
                        ".college-card"
                    );


                cards.forEach(card => {

                    const collegeId =
                        card.dataset.collegeId;


                    const college =
                        colleges.find(item =>
                            String(item.id) ===
                            String(collegeId)
                        );


                    if (!college) {
                        return;
                    }


                    const searchableText = [

                        college.name,
                        college.location,
                        college.type,
                        college.state,
                        college.description,
                        college.courses

                    ]
                        .filter(Boolean)
                        .join(" ")
                        .toLowerCase();


                    const matches =
                        searchableText.includes(
                            searchText
                        );


                    card.style.display =
                        matches ? "" : "none";


                    if (matches) {
                        visibleCards++;
                    }

                });


                if (collegeNoResults) {

                    collegeNoResults.style.display =
                        visibleCards === 0
                            ? "block"
                            : "none";

                }

            }
        );


        /* =========================
           VIEW DETAILS
           ========================= */

        collegeGrid.addEventListener(
            "click",
            event => {

                const button =
                    event.target.closest(
                        ".college-view-btn"
                    );


                if (!button) {
                    return;
                }


                const card =
                    button.closest(
                        ".college-card"
                    );


                if (!card) {
                    return;
                }


                const collegeId =
                    card.dataset.collegeId;


                const selectedCollege =
                    colleges.find(college =>
                        String(college.id) ===
                        String(collegeId)
                    );


                if (selectedCollege) {

                    displayCollegeDetails(
                        selectedCollege
                    );

                }

            }
        );


    } catch (error) {

        console.error(
            "College backend connection failed:",
            error
        );


        collegeGrid.innerHTML = `

            <div class="college-empty-state">

                <h3>
                    Unable to load colleges
                </h3>

                <p>
                    Please start the Spring Boot
                    backend and try again.
                </p>

            </div>

        `;

    }
}


/* =====================================================
   COLLEGE DETAILS
   ===================================================== */

function displayCollegeDetails(college) {

    const selectedCollegeName =
        document.getElementById(
            "selectedCollegeName"
        );


    const detailContent =
        document.getElementById(
            "collegeDetailContent"
        );


    if (!detailContent) {
        return;
    }


    if (selectedCollegeName) {

        selectedCollegeName.textContent =
            college.name;

    }


    detailContent.innerHTML = `

        <div class="college-detail-panel">

            <div class="college-detail-box">

                <span>
                    LOCATION
                </span>

                <strong>
                    ${escapeHTML(
                        college.location ||
                        "Not specified"
                    )}
                </strong>

            </div>


            <div class="college-detail-box">

                <span>
                    TYPE
                </span>

                <strong>
                    ${escapeHTML(
                        college.type ||
                        "Not specified"
                    )}
                </strong>

            </div>


            <div class="college-detail-box">

                <span>
                    STATE
                </span>

                <strong>
                    ${escapeHTML(
                        college.state ||
                        "Not specified"
                    )}
                </strong>

            </div>

        </div>


        <div class="college-description-box">

            <h3>
                About the College
            </h3>

            <p>
                ${escapeHTML(
                    college.description ||
                    "College description will be added soon."
                )}
            </p>


            <h3>
                Courses
            </h3>

            <p>
                ${escapeHTML(
                    college.courses ||
                    "Course information will be added soon."
                )}
            </p>


            <h3>
                Official Website
            </h3>

            <p>

                ${
                    college.website
                        ? `
                            <a
                                href="${college.website}"
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                ${escapeHTML(
                                    college.website
                                )}
                            </a>
                          `
                        : "Website information will be added soon."
                }

            </p>

        </div>

    `;


    scrollToElement(
        "collegeDetails"
    );
}


    /* =====================================================
       SCHOLARSHIP EXPLORER
       ===================================================== */

    /* =====================================================
   SCHOLARSHIP EXPLORER
   ===================================================== */

async function initializeScholarshipExplorer() {

    const scholarshipGrid =
        document.getElementById("scholarshipGrid");

    const scholarshipSearch =
        document.getElementById("scholarshipSearch");

    const scholarshipNoResults =
        document.getElementById("scholarshipNoResults");

    const scholarshipCount =
        document.getElementById("scholarshipCount");


    if (!scholarshipGrid || !scholarshipSearch) {
        return;
    }


    try {

        const response =
            await fetch(
                "http://localhost:8080/api/scholarships"
            );


        if (!response.ok) {
            throw new Error(
                "Unable to load scholarships"
            );
        }


        const scholarships =
            await response.json();

        console.log(
            "Scholarships loaded:",
            scholarships
        );


        if (scholarshipCount) {
            scholarshipCount.textContent =
                `${scholarships.length} scholarships available`;
        }


        scholarshipGrid.innerHTML = "";


        scholarships.forEach(scholarship => {

            const card =
                document.createElement("div");

            card.className =
                "scholarship-card";

            card.dataset.scholarshipId =
                scholarship.id;


            card.innerHTML = `

                <div class="scholarship-icon">
                    🎓
                </div>

                <h3>
                    ${escapeHTML(
                        scholarship.name
                    )}
                </h3>

                <p>
                    ${escapeHTML(
                        scholarship.description ||
                        "Scholarship information available."
                    )}
                </p>

                <div class="scholarship-tags">

                    <span>
                        ${escapeHTML(
                            scholarship.category ||
                            "General"
                        )}
                    </span>

                    <span>
                        ${escapeHTML(
                            scholarship.amount ||
                            "Amount varies"
                        )}
                    </span>

                </div>

                <button
                    class="scholarship-view-btn"
                    type="button"
                >
                    View Details →
                </button>

            `;


            scholarshipGrid.appendChild(card);

        });


        /* =========================
           SEARCH
           ========================= */

        scholarshipSearch.addEventListener(
            "input",
            () => {

                const searchText =
                    scholarshipSearch.value
                        .trim()
                        .toLowerCase();


                let visibleCards = 0;


                const cards =
                    scholarshipGrid.querySelectorAll(
                        ".scholarship-card"
                    );


                cards.forEach(card => {

                    const scholarshipId =
                        card.dataset.scholarshipId;


                    const scholarship =
                        scholarships.find(item =>
                            String(item.id) ===
                            String(scholarshipId)
                        );


                    if (!scholarship) {
                        return;
                    }


                    const searchableText = [

                        scholarship.name,
                        scholarship.provider,
                        scholarship.eligibility,
                        scholarship.category,
                        scholarship.amount,
                        scholarship.description

                    ]
                        .filter(Boolean)
                        .join(" ")
                        .toLowerCase();


                    const matches =
                        searchableText.includes(
                            searchText
                        );


                    card.style.display =
                        matches ? "" : "none";


                    if (matches) {
                        visibleCards++;
                    }

                });


                if (scholarshipNoResults) {

                    scholarshipNoResults.style.display =
                        visibleCards === 0
                            ? "block"
                            : "none";

                }

            }
        );


        /* =========================
           VIEW DETAILS
           ========================= */

        scholarshipGrid.addEventListener(
            "click",
            event => {

                const button =
                    event.target.closest(
                        ".scholarship-view-btn"
                    );


                if (!button) {
                    return;
                }


                const card =
                    button.closest(
                        ".scholarship-card"
                    );


                if (!card) {
                    return;
                }


                const scholarshipId =
                    card.dataset.scholarshipId;


                const selectedScholarship =
                    scholarships.find(scholarship =>
                        String(scholarship.id) ===
                        String(scholarshipId)
                    );


                if (selectedScholarship) {

                    displayScholarshipDetails(
                        selectedScholarship
                    );

                }

            }
        );


    } catch (error) {

        console.error(
            "Scholarship backend connection failed:",
            error
        );


        scholarshipGrid.innerHTML = `

            <div class="scholarship-empty-state">

                <h3>
                    Unable to load scholarships
                </h3>

                <p>
                    Please start the Spring Boot
                    backend and try again.
                </p>

            </div>

        `;

    }
}


/* =====================================================
   SCHOLARSHIP DETAILS
   ===================================================== */

function displayScholarshipDetails(scholarship) {

    const selectedScholarshipName =
        document.getElementById(
            "selectedScholarshipName"
        );


    const detailContent =
        document.getElementById(
            "scholarshipDetailContent"
        );


    if (!detailContent) {
        return;
    }


    if (selectedScholarshipName) {

        selectedScholarshipName.textContent =
            scholarship.name;

    }


    detailContent.innerHTML = `

        <div class="scholarship-detail-panel">

            <div class="scholarship-detail-box">

                <span>
                    PROVIDER
                </span>

                <strong>
                    ${escapeHTML(
                        scholarship.provider ||
                        "Not specified"
                    )}
                </strong>

            </div>


            <div class="scholarship-detail-box">

                <span>
                    CATEGORY
                </span>

                <strong>
                    ${escapeHTML(
                        scholarship.category ||
                        "Not specified"
                    )}
                </strong>

            </div>


            <div class="scholarship-detail-box">

                <span>
                    AMOUNT
                </span>

                <strong>
                    ${escapeHTML(
                        scholarship.amount ||
                        "Not specified"
                    )}
                </strong>

            </div>

        </div>


        <div class="scholarship-description-box">

            <h3>
                Eligibility
            </h3>

            <p>
                ${escapeHTML(
                    scholarship.eligibility ||
                    "Eligibility information will be added soon."
                )}
            </p>


            <h3>
                About the Scholarship
            </h3>

            <p>
                ${escapeHTML(
                    scholarship.description ||
                    "Scholarship description will be added soon."
                )}
            </p>


            <h3>
                Official Website
            </h3>

            <p>

                ${
                    scholarship.website
                        ? `
                            <a
                                href="${scholarship.website}"
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                ${escapeHTML(
                                    scholarship.website
                                )}
                            </a>
                          `
                        : "Website information will be added soon."
                }

            </p>

        </div>

    `;


    scrollToElement(
        "scholarshipDetails"
    );
}

   /* =====================================================
   PATHWAY EXPLORER
   ===================================================== */

async function initializePathwayExplorer() {

    const pathwayGrid =
        document.getElementById("pathwayGrid");

    const pathwaySearch =
        document.getElementById("pathwaySearch");

    const pathwayNoResults =
        document.getElementById("pathwayNoResults");

    const pathwayCount =
        document.getElementById("pathwayCount");


    if (!pathwayGrid || !pathwaySearch) {
        return;
    }


    try {

        const response =
            await fetch(
                "http://localhost:8080/api/pathways"
            );


        if (!response.ok) {
            throw new Error(
                "Unable to load pathways"
            );
        }


        const pathways =
            await response.json();

        console.log(
            "Pathways loaded:",
            pathways
        );


        if (pathwayCount) {
            pathwayCount.textContent =
                `${pathways.length} pathways available`;
        }


        pathwayGrid.innerHTML = "";


        pathways.forEach(pathway => {

            const card =
                document.createElement("div");

            card.className =
                "pathway-card";

            card.dataset.pathwayId =
                pathway.id;


            card.innerHTML = `

                <div class="pathway-icon">
                    🧭
                </div>

                <h3>
                    ${escapeHTML(
                        pathway.fromNode
                    )}
                    →
                    ${escapeHTML(
                        pathway.toNode
                    )}
                </h3>

                <p>
                    ${escapeHTML(
                        pathway.description ||
                        "Educational pathway information available."
                    )}
                </p>

                <div class="pathway-tags">

                    <span>
                        ${escapeHTML(
                            pathway.relationship ||
                            "Pathway"
                        )}
                    </span>

                    ${
                        pathway.duration
                            ? `
                                <span>
                                    ${escapeHTML(
                                        pathway.duration
                                    )}
                                </span>
                              `
                            : ""
                    }

                </div>

                <button
                    class="pathway-view-btn"
                    type="button"
                >
                    Explore Pathway →
                </button>

            `;


            pathwayGrid.appendChild(card);

        });


        /* =========================
           SEARCH
           ========================= */

        pathwaySearch.addEventListener(
            "input",
            () => {

                const searchText =
                    pathwaySearch.value
                        .trim()
                        .toLowerCase();


                let visibleCards = 0;


                const cards =
                    pathwayGrid.querySelectorAll(
                        ".pathway-card"
                    );


                cards.forEach(card => {

                    const pathwayId =
                        card.dataset.pathwayId;


                    const pathway =
                        pathways.find(item =>
                            String(item.id) ===
                            String(pathwayId)
                        );


                    if (!pathway) {
                        return;
                    }


                    const searchableText = [

                        pathway.fromNode,
                        pathway.toNode,
                        pathway.relationship,
                        pathway.description,
                        pathway.requiredSkills,
                        pathway.careerOpportunities,
                        pathway.jobRoles,
                        pathway.higherStudies,
                        pathway.entranceExams,
                        pathway.colleges,
                        pathway.futureScope

                    ]
                        .filter(Boolean)
                        .join(" ")
                        .toLowerCase();


                    const matches =
                        searchableText.includes(
                            searchText
                        );


                    card.style.display =
                        matches ? "" : "none";


                    if (matches) {
                        visibleCards++;
                    }

                });


                if (pathwayNoResults) {

                    pathwayNoResults.style.display =
                        visibleCards === 0
                            ? "block"
                            : "none";

                }

            }
        );


        /* =========================
           VIEW DETAILS
           ========================= */

        pathwayGrid.addEventListener(
            "click",
            event => {

                const button =
                    event.target.closest(
                        ".pathway-view-btn"
                    );


                if (!button) {
                    return;
                }


                const card =
                    button.closest(
                        ".pathway-card"
                    );


                if (!card) {
                    return;
                }


                const pathwayId =
                    card.dataset.pathwayId;


                const selectedPathway =
                    pathways.find(pathway =>
                        String(pathway.id) ===
                        String(pathwayId)
                    );


                if (selectedPathway) {

                    displayPathwayDetails(
                        selectedPathway
                    );

                }

            }
        );


    } catch (error) {

        console.error(
            "Pathway backend connection failed:",
            error
        );


        pathwayGrid.innerHTML = `

            <div class="pathway-empty-state">

                <h3>
                    Unable to load pathways
                </h3>

                <p>
                    Please start the Spring Boot
                    backend and try again.
                </p>

            </div>

        `;

    }
}


/* =====================================================
   PATHWAY DETAILS
   ===================================================== */

function displayPathwayDetails(pathway) {

    const selectedPathwayName =
        document.getElementById(
            "selectedPathwayName"
        );


    const detailContent =
        document.getElementById(
            "pathwayDetailContent"
        );


    if (!detailContent) {
        return;
    }


    if (selectedPathwayName) {

        selectedPathwayName.textContent =
            `${pathway.fromNode} → ${pathway.toNode}`;

    }


    detailContent.innerHTML = `

        <div class="pathway-detail-panel">

            <div class="pathway-detail-box">

                <span>
                    FROM
                </span>

                <strong>
                    ${escapeHTML(
                        pathway.fromNode
                    )}
                </strong>

            </div>


            <div class="pathway-detail-box">

                <span>
                    RELATIONSHIP
                </span>

                <strong>
                    ${escapeHTML(
                        pathway.relationship ||
                        "Educational Pathway"
                    )}
                </strong>

            </div>


            <div class="pathway-detail-box">

                <span>
                    TO
                </span>

                <strong>
                    ${escapeHTML(
                        pathway.toNode
                    )}
                </strong>

            </div>


            <div class="pathway-detail-box">

                <span>
                    DURATION
                </span>

                <strong>
                    ${escapeHTML(
                        pathway.duration ||
                        "Varies"
                    )}
                </strong>

            </div>

        </div>


        <div class="pathway-description-box">

            <h3>
                📖 About This Pathway
            </h3>

            <p>
                ${escapeHTML(
                    pathway.description ||
                    "Information not available."
                )}
            </p>


            <h3>
                📋 Eligibility
            </h3>

            <p>
                ${escapeHTML(
                    pathway.eligibility ||
                    "Eligibility information not available."
                )}
            </p>


            <h3>
                🛠️ Required Skills
            </h3>

            <p>
                ${escapeHTML(
                    pathway.requiredSkills ||
                    "Skill information not available."
                )}
            </p>


            <h3>
                💼 Career Opportunities
            </h3>

            <p>
                ${escapeHTML(
                    pathway.careerOpportunities ||
                    "Career information not available."
                )}
            </p>


            <h3>
                👨‍💻 Job Roles
            </h3>

            <p>
                ${escapeHTML(
                    pathway.jobRoles ||
                    "Job role information not available."
                )}
            </p>


            <h3>
                🎓 Higher Studies
            </h3>

            <p>
                ${escapeHTML(
                    pathway.higherStudies ||
                    "Higher study information not available."
                )}
            </p>


            <h3>
                📝 Entrance Exams
            </h3>

            <p>
                ${escapeHTML(
                    pathway.entranceExams ||
                    "Entrance exam information not available."
                )}
            </p>


            <h3>
                🏫 Colleges / Institutions
            </h3>

            <p>
                ${escapeHTML(
                    pathway.colleges ||
                    "College information not available."
                )}
            </p>


            <h3>
                🚀 Future Scope
            </h3>

            <p>
                ${escapeHTML(
                    pathway.futureScope ||
                    "Future scope information not available."
                )}
            </p>

        </div>

    `;


    scrollToElement(
        "pathwayDetails"
    );
}




    /* =====================================================
       HELPER FUNCTIONS
       ===================================================== */

    function getFieldIcon(index) {

        const icons = [
            "⚙",
            "∑",
            "◇",
            "▣",
            "⚕",
            "✦"
        ];


        return icons[
            index % icons.length
        ];

    }


    function getCourseIcon(index) {

        const icons = [
            "◇",
            "⌘",
            "⚙",
            "▣",
            "✦",
            "↗"
        ];


        return icons[
            index % icons.length
        ];

    }


    function normalizeStreamName(name) {

        const value =
            String(name || "")
                .toLowerCase()
                .replace(/\s+/g, "")
                .replace(/[^a-z0-9]/g, "");


        if (value === "artshumanities") {

            return "arts";

        }


        return value;

    }


    function escapeHTML(value) {

        return String(value)
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;")
            .replace(/'/g, "&#039;");

    }


    function scrollToElement(
        elementId
    ) {

        const element =
            document.getElementById(
                elementId
            );


        if (element) {

            element.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });

        }

    }


    function showBackendMessage(
        fieldGrid
    ) {

        if (!fieldGrid) {
            return;
        }


        fieldGrid.innerHTML = `

            <div class="empty-field-state">

                <div class="empty-icon">
                    ◇
                </div>

                <h3>
                    Connect to EduGuide
                </h3>

                <p>
                    Start the Spring Boot backend
                    to view fields and courses.
                </p>

            </div>

        `;

    }


    /* =====================================================
       START ALL EXPLORERS
       ===================================================== */

    initializeCareerExplorer();

    initializeExamExplorer();

    initializeCollegeExplorer();

    initializeScholarshipExplorer();

    initializePathwayExplorer();


    /* =====================================================
       LOAD SPRING BOOT DATA
       ===================================================== */

    loadEduGuideData();


});