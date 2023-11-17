function addExperience(){
    const allDivExperience = document.querySelectorAll("[id^='divExperience']");
    const divExperienceCount = allDivExperience.length;

    const html = `
        <div class="form-inline px-2 border-bottom border-4 mx-2" id="divExperience${divExperienceCount}">
            <input type="hidden" name="experienceId" th:value="0"/>
            <div class="row">
                <div class="col-md-4">
                    <label class="form-label">Company Name:</label>
                    <input class="form-control" type="text" name="experienceCompanyName"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Role:</label>
                    <input class="form-control" type="text" name="experienceRole"/>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Work Description:</label>
                    <input class="form-control" type="text" name="experienceWorkDescription"/>
                </div>
                <div class="col-md-6">
                    <label class="form-label">From Date:</label>
                    <input class="form-control" type="date" name="experienceFormDate"/>
                </div>
                <div class="col-md-6">
                    <label class="form-label">To Date:</label>
                    <input class="form-control" type="date" name="experienceToDate"/>
                </div>
            </div>
        </div>   
    `

    document.querySelector("#experienceContainer").insertAdjacentHTML("beforeend", html)
}