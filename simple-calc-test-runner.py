import subprocess
import argparse
import os

def run_command(command, reports_dir, logs_dir):
    try:
        os.makedirs(reports_dir, exist_ok=True)
        os.makedirs(logs_dir, exist_ok=True)

        stdout_log_path = os.path.join(logs_dir, 'stdout.log')
        stderr_log_path = os.path.join(logs_dir, 'stderr.log')

        with open(stdout_log_path, 'w') as stdout_file, open(stderr_log_path, 'w') as stderr_file:
            subprocess.run(command, stdout=stdout_file, stderr=stderr_file, check=True)

    except subprocess.CalledProcessError as e:
        print(f"Command '{e.cmd}' returned non-zero exit status {e.returncode}.")
    except Exception as e:
        print(f"An error occurred: {e}")

def main():
    parser = argparse.ArgumentParser(description="SimpleCalc Test Runner")
    parser.add_argument("--run", choices=['unittests', 'scenarios'], required=True, help="Type of tests to run")
    parser.add_argument("--reports-dir", required=True, help="Directory to save reports")
    parser.add_argument("--logs-dir", default="logs", help="Directory to save logs")

    args = parser.parse_args()

    if args.run == 'unittests':
        # Passing reports directory for unit tests
        command = ['gradle', 'unitTests', f'-PreportsDirProperty={args.reports_dir}/unit_tests']
        reports_dir = os.path.join(args.reports_dir, 'unit_tests')
    elif args.run == 'scenarios':
        # Passing reports directory for BDD scenarios
        command = ['gradle', 'test', f'-PreportsDirProperty={args.reports_dir}/bdd_scenarios']
        reports_dir = os.path.join(args.reports_dir, 'bdd_scenarios')

    run_command(command, reports_dir, args.logs_dir)

if __name__ == "__main__":
    main()
