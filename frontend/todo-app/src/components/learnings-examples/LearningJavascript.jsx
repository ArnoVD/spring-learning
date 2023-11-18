export default function LearningJavascript() {
    const person = {
        firstName: "John",
        lastName: "Doe",
        age: 50,
        eyeColor: "blue",
        profiles: ["Twitter", "LinkedIn", "Facebook"],
        printProfile: () => {
            return person.profiles.map(profile => {
                return profile + ", ";
            });
        }
    };
    return (
        <div className="LearningJavascript">
            <h1>{person.firstName}</h1>
            <h1>{person.printProfile()}</h1>
        </div>
    );
}